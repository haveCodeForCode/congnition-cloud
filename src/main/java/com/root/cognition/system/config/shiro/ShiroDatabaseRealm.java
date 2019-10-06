package com.root.cognition.system.config.shiro;

import com.auth0.jwt.JWT;
import com.root.cognition.common.config.Constant;
import com.root.cognition.common.until.StringUtils;
import com.root.cognition.system.config.ApplicationContextRegister;
import com.root.cognition.system.config.jwt.JwtToken;
import com.root.cognition.system.config.jwt.JwtUtill;
import com.root.cognition.system.dao.UserDao;
import com.root.cognition.system.entity.User;
import com.root.cognition.system.service.MenuService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

/**
 * @author 1122
 * @version 2019/9/28
 */
public class ShiroDatabaseRealm extends AuthorizingRealm {

    /**
     * 日志
     */
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    /**
     * 授权身份信息
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        logger.info("授权身份信息：" + principalCollection.toString());
        //菜单服务类注册
        MenuService menuService = ApplicationContextRegister.getBean(MenuService.class);
        //获取userID
        String userId = JwtUtill.getUserId(principalCollection.toString());
        //新建授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //判断用户对象是否为空
        if (StringUtils.isNotEmpty(userId)) {
            Set<String> perms = menuService.menuListPerms(Long.valueOf(userId));
            info.setStringPermissions(perms);
        }
        return info;
    }

    /**
     * 替换原本shiro token
     *
     * @param token
     * @return
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        //JWTtoken
        return token instanceof JwtToken;
        //        return super.supports(token);
    }

    /**
     * 验证身份信息
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String token = authenticationToken.getCredentials().toString();
        String userId = JwtUtill.getUserId(token);
        UserDao userDao = ApplicationContextRegister.getBean(UserDao.class);
        if (StringUtils.isNotEmpty(userId)){
            User user= userDao.get(Long.valueOf(userId));
            if (user!=null){
                if (user.getDelFlag().equals(Constant.STRING_ZERO)){
                    throw new DisabledAccountException("901");
                }
                if(!JwtUtill.verify(token,userId,user.getUserPassword())){
                    throw new UnknownAccountException("900");
                }
                return new SimpleAuthenticationInfo(token, token, "realm");
            }else {
                throw new UnknownAccountException("900");
            }
        }else{
            throw new UnknownAccountException("900");
        }
    }
}
