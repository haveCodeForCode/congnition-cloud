package com.realm.cognitionauth.entity;

import java.io.Serializable;

/**
 * 客户端对象
 * @author 1122
 * @since 2019-07-25
 */
public class OauthClientDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 客户端ID
     */
    private String clientId;
    /**
     * 客户端所能访问的资源id集合
     */
    private String resourceIds;
    /**
     * 客户端(client)的访问密匙
     */
    private String clientSecret;
    /**
     *
     */
    private String scope;
    /**
     * 客户端支持的grant_type授权类型
     */
    private String authorizedGrantTypes;
    /**
     *
     */
    private String webServerRedirectUrl;
    /**
     *
     */
    private String authorities;

    /**
     *
     */
    private Integer accessTokenValidity;

    /**
     *
     */
    private Integer refreshTokenValidity;

    /**
     *
     */
    private String additionalInformation;

    /**
     *
     */
    private String autoapprove;


    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getResourceIds() {
        return resourceIds;
    }

    public void setResourceIds(String resourceIds) {
        this.resourceIds = resourceIds;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getAuthorizedGrantTypes() {
        return authorizedGrantTypes;
    }

    public void setAuthorizedGrantTypes(String authorizedGrantTypes) {
        this.authorizedGrantTypes = authorizedGrantTypes;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public Integer getAccessTokenValidity() {
        return accessTokenValidity;
    }

    public void setAccessTokenValidity(Integer accessTokenValidity) {
        this.accessTokenValidity = accessTokenValidity;
    }

    public Integer getRefreshTokenValidity() {
        return refreshTokenValidity;
    }

    public void setRefreshTokenValidity(Integer refreshTokenValidity) {
        this.refreshTokenValidity = refreshTokenValidity;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public String getAutoapprove() {
        return autoapprove;
    }

    public void setAutoapprove(String autoapprove) {
        this.autoapprove = autoapprove;
    }

    public String getWebServerRedirectUrl() {
        return webServerRedirectUrl;
    }

    public void setWebServerRedirectUrl(String webServerRedirectUrl) {
        this.webServerRedirectUrl = webServerRedirectUrl;
    }

    @Override
    public String toString() {
        return "OauthClientDetails{" +
                "clientId='" + clientId + '\'' +
                ", resourceIds='" + resourceIds + '\'' +
                ", clientSecret='" + clientSecret + '\'' +
                ", scope='" + scope + '\'' +
                ", authorizedGrantTypes='" + authorizedGrantTypes + '\'' +
                ", webServerRedirectUrl='" + webServerRedirectUrl + '\'' +
                ", authorities='" + authorities + '\'' +
                ", accessTokenValidity=" + accessTokenValidity +
                ", refreshTokenValidity=" + refreshTokenValidity +
                ", additionalInformation='" + additionalInformation + '\'' +
                ", autoapprove='" + autoapprove + '\'' +
                '}';
    }
}
