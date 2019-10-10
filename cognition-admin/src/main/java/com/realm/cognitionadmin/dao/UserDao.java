package com.realm.cognitionadmin.dao;

import com.realm.cognitionadmin.entity.User;
import com.realm.cognitioncommon.persistence.BaseDao;
import org.springframework.stereotype.Repository;


/**
 * @author 王睿
 * @version 2018/12/24
 */
@Repository("UserDao")
public interface UserDao extends BaseDao<User> {

    /**
     * 根据登陆传入信息擦护心用户（手机、邮箱）
     * @param loginInfo
     * @return
     */
    User getWihtLogininfo(String loginInfo);
}
