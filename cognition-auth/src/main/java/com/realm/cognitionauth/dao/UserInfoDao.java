package com.realm.cognitionauth.dao;

import com.realm.cognitionauth.entity.UserInfo;
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
