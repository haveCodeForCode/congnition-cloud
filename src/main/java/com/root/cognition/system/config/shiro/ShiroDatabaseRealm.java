package com.root.cognition.system.config.shiro;

import com.root.cognition.system.config.jwt.JwtUtill;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 1122
 * @version 2019/9/28
 */
public class ShiroDatabaseRealm extends AuthorizingRealm {

    /**
     * 日志
     */
    private Logger logger = LoggerFactory.getLogger(this.getClass());

//   logger.info("授权身份信息："+principalCollection.toString());

    /**
     * 授权身份信息
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        logger.info("登录人用户名：" + principalCollection.toString());
        String userName = JwtUtill.getUsername(principalCollection.toString());

        return null;
    }

    /**
     * 验证身份信息
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        return null;
    }
}
