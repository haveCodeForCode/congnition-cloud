package com.root.cognition.system.config.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.root.cognition.common.config.ProjectConfig;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * @author Worry
 * @version 2019/9/27
 */
public class JwtUtill {

    /**
     * 过期时间
     */
    private static final long EXPIRE_TIME_PRESET = 24 * 60 * 1000;

    private ProjectConfig projectConfig;

    @Resource
    public void setProjectConfig(ProjectConfig projectConfig) {
        this.projectConfig = projectConfig;
    }

    /**
     * 效验token是否正确
     *
     * @param token
     * @param username
     * @param password
     * @return
     */
    public static boolean verify(String token, String username, String password) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(password);
            JWTVerifier verifier = JWT.require(algorithm).withClaim("username", username).build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    /**
     * 获取登录名
     *
     * @param token 传入值编码获取
     * @return
     */
    public static String getUsername(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("username").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }


    /**
     * 生成签名
     *
     * @param username
     * @param password
     * @return
     */
    public String sign(String username, String password) {
        try {
            long time = EXPIRE_TIME_PRESET * projectConfig.getJwtTime();
            // 指定过期时间
            Date date = new Date(System.currentTimeMillis() + time);

            Algorithm algorithm = Algorithm.HMAC256(password);
            return JWT.create()
                    .withClaim("username", username)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }


}
