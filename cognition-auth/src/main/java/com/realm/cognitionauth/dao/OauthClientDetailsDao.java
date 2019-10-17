package com.realm.cognitionauth.dao;

import com.realm.cognitionauth.entity.OauthClientDetails;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Worry
 * @version 2019/10/17
 */
@Mapper
public interface OauthClientDetailsDao {

    /**
     * 根据客户端ID获取客户端内容
     * @param clientId
     * @return
     */
    OauthClientDetails getOauthClientDetailsByClientId(String clientId);

}
