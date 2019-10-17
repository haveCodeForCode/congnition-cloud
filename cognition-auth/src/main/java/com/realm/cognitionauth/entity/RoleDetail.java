package com.realm.cognitionauth.entity;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author Worry
 * @version 2019/10/18
 */
public class RoleDetail implements GrantedAuthority  {
    @Override
    public String getAuthority() {
        return null;
    }
}
