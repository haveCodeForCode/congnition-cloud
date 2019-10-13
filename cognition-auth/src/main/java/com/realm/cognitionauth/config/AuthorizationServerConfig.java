package com.realm.cognitionauth.config;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;

/**
 * @author Worry
 * @version 2019/10/13
 * 指定认证中心，指定客户端， 指定token的存储方式等。
 */
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    private AuthenticationManager authenticationManager;

}
