package com.realm.cognitionauth.config;

import com.realm.cognitionauth.dao.OauthClientDetailsDao;
import com.realm.cognitionauth.entity.OauthClientDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * 客户端详情信息，客户端详情信息在这里进行初始化，通过数据库来存储调取详情信息
 * <p>
 * 用户登录时（即携带参数请求/oauth/token接口）会调用这两个service。
 * 1、MyClientDetailsService是根据client_id查出来的信息验证用户登录时携带的参数（即客户端详情表信息）是否正确。并且设置能访问的资源id集合。
 * 2、MyUserDetailService是根据用户名去查用户密码，用户所拥有的角色等信息，然后丢给security去验证用户登录时的用户名和密码是否正确。
 * <p>
 * 以上都正确则返回token信息，并把token信息存到了token详情表，refresh_token详情表中（token存储方式为数据库）。然后就可以根据拿到的token去请求被security管理起来的接口地址。
 *
 * @author 1122
 */
@Service
public class ClientDetailServiceImpl implements ClientDetailsService {

    @Resource
    private OauthClientDetailsDao oauthClientDetailsDao;

    @Override
    public ClientDetails loadClientByClientId(String s) throws ClientRegistrationException {
        OauthClientDetails oauthClientDetails= oauthClientDetailsDao.getOauthClientDetailsByClientId(s);
        BaseClientDetails clientDetails = new BaseClientDetails();
        //客户端(client)id
        clientDetails.setClientId(oauthClientDetails.getClientId());
        //客户端所能访问的资源id集合
//        clientDetails.setResourceIds(Arrays.asList(oauthClientDetails.getResourceIds().split(",")));
        //客户端(client)的访问密匙
        clientDetails.setClientSecret(new BCryptPasswordEncoder().encode(oauthClientDetails.getClientSecret()));
        //客户端支持的grant_type授权类型
//        clientDetails.setAuthorizedGrantTypes(Arrays.asList(oauthClientDetails.getAuthorizedGrantTypes().split(",")));
        //客户端申请的权限范围
//        clientDetails.setScope(Arrays.asList(oauthClientDetails.getScope().split(",")));

        Integer accessTokenValidity = oauthClientDetails.getAccessTokenValidity();
        if (accessTokenValidity != null && accessTokenValidity > 0) {
            //设置token的有效期，不设置默认12小时
            clientDetails.setAccessTokenValiditySeconds(accessTokenValidity);
        }
        Integer refreshTokenValidity = oauthClientDetails.getRefreshTokenValidity();
        if (refreshTokenValidity != null && refreshTokenValidity > 0) {
            //设置刷新token的有效期，不设置默认30天
            clientDetails.setRefreshTokenValiditySeconds(refreshTokenValidity);
        }
        System.err.println("clientId是：" + s);
        return clientDetails;
    }
}
