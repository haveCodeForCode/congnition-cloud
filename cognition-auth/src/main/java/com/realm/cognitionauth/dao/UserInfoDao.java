package com.realm.cognitionauth.dao;

import com.realm.cognitionauth.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 用户信息Dao层
 *
 * @author Worry
 * @version 2019/4/1
 */
@Repository("UserInfoDao")
public interface UserInfoDao extends JpaRepository<UserInfo,Long> {


}
