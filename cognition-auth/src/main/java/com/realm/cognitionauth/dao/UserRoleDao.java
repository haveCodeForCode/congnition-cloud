package com.realm.cognitionauth.dao;

import com.realm.cognitionauth.entity.UserRole;
import com.realm.cognitioncommon.persistence.BaseDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户相关信息Dao
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-10-03 11:08:59
 */
@Repository("UserRelationDao")
public interface UserRoleDao extends JpaRepository<UserRole,Long> {

}
