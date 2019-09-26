package com.root.cognition.system.config.jwt;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author 1122
 * @version 2019/9/26
 */
public class JwtToken implements AuthenticationToken {


    private String token;

    public JwtToken(String token){
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }

    @Override
    public Object getCredentials() {
        return null;
    }
}
