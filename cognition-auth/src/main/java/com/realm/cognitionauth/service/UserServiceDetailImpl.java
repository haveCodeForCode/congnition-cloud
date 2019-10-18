package com.realm.cognitionauth.service;

import com.realm.cognitionauth.entity.UserAuthDetails;
import com.realm.cognitionsystem.entity.SysRole;
import com.realm.cognitionsystem.entity.SysUser;
import com.realm.cognitionsystem.service.ISysRoleService;
import com.realm.cognitionsystem.service.ISysUserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Worry
 * @version 2019/10/17
 */
@Service
public class UserServiceDetailImpl implements UserDetailsService {


    private ISysUserService iSysUserService;

    private ISysRoleService iSysRoleService;

    @Resource
    public void setiSysUserService(ISysUserService iSysUserService) {
        this.iSysUserService = iSysUserService;
    }

    /**
     * 组装对应的服务字段权限
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAuthDetails userAuthDetails = new UserAuthDetails();
        SysUser sysUser= iSysUserService.selectUserByLoginName(username);
        List<SysRole> sysRoleList =iSysRoleService.selectRolesByUserId(sysUser.getUserId());
        userAuthDetails.setUsername(sysUser.getUserName());
        userAuthDetails.setPassword(sysUser.getPassword());

        List<GrantedAuthority> userGrantedAuthorityList = new ArrayList<>();
        for (SysRole sysRole: sysRoleList) {
            GrantedAuthority grantedAuthority = new GrantedAuthority() {
                @Override
                public String getAuthority() {
                    return sysRole.getRoleName();
                }
            };
            userGrantedAuthorityList.add(grantedAuthority);
        }
        userAuthDetails.setGrantedAuthorityList(userGrantedAuthorityList);
        return userAuthDetails;

    }
}
