package com.realm.cognitionauth.service;

import com.realm.cognitionsystem.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;

/**
 * @author Worry
 * @version 2019/10/17
 */
public class UserServiceDetail implements UserDetailsService {


    private ISysUserService iSysUserService;

    @Autowired
    public void setiSysUserService(ISysUserService iSysUserService) {
        this.iSysUserService = iSysUserService;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        return iSysUserService.selectUserDetailsByLoginId(s);

    }
}
