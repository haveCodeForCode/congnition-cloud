package com.realm.cognitionauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;


/**
 * @author 1122
 * @version 2019/10/13
 * 指定认证中心，指定客户端， 指定token的存储方式等。
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {


    private RedisConnectionFactory redisConnectionFactory;
    /**
     * 客户端详情
     */
    private ClientDetailServiceImpl clientDetailService;

    @Autowired
    public void setRedisConnectionFactory(RedisConnectionFactory redisConnectionFactory) {
        this.redisConnectionFactory = redisConnectionFactory;
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
        return new RedisTokenStore(redisConnectionFactory);

        //********jwt存储******//
        //return new JwtTokenStore(jwtAccessTokenConverter());

        //********存数据库******//
        //return new JdbcTokenStore(dataSource);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(clientDetailService)
                .withClient()
        super.configure(clients);
    }
}
