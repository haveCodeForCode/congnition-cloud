package com.realm.cognitionadmin.dao;

import com.realm.cognitionadmin.entity.UserInfo;
import com.realm.cognitioncommon.persistence.BaseDao;
import org.springframework.stereotype.Repository;

/**
 * 用户信息Dao层
 *
 * @author Worry
 * @version 2019/4/1
 */
@Repository("UserInfoDao")
public interface UserInfoDao extends BaseDao<UserInfo> {

}
