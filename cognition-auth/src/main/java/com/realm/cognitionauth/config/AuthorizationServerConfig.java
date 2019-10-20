package com.realm.cognitionauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import javax.annotation.Resource;


/**
 * @author 1122
 * @version 2019/10/13
 * 指定认证中心，指定客户端， 指定token的存储方式等。
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    /**
     * 客户端详情
     */
    private ClientDetailServiceImpl clientDetailService;

    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthorizationServerConfig(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Autowired
    public void setClientDetailService(ClientDetailServiceImpl clientDetailService) {
        this.clientDetailService = clientDetailService;
    }

    /**
     * token的存放方式
     *
     * @return
     */
    public TokenStore tokenStore() {
        //********存内存******//
        //return new InMemoryTokenStore();

        //********存redis******//
//        return new RedisTokenStore(redisConnectionFactory);

        //********jwt存储******//
        return new JwtTokenStore(jwtAccessTokenConverter());

        //********存数据库******//
        //return new JdbcTokenStore(dataSource);
    }


    /**
     * 客服验证设置
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(clientDetailService)
                .clients(clientDetailService);
    }

    /**
     * 用户验证设置
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(tokenStore()).tokenEnhancer(jwtAccessTokenConverter()).authenticationManager(authenticationManager);
        super.configure(endpoints);
    }


    /**
     * 访问令牌转换器
     * @return
     */
    @Bean
    protected JwtAccessTokenConverter jwtAccessTokenConverter() {
        //注意此处需要相应的jks文件
        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new ClassPathResource("cognition-jwt.jks"), "codebug19960212".toCharArray());
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setKeyPair(keyStoreKeyFactory.getKeyPair("cognition-jwt"));
        return converter;
    }
}
