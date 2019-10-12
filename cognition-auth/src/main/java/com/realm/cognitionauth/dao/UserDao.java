package com.realm.cognitionauth.dao;

import com.realm.cognitionauth.entity.User;
import com.realm.cognitioncommon.persistence.BaseDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * @author 王睿
 * @version 2018/12/24
 */
@Repository("UserDao")
public interface UserDao extends JpaRepository<User,Long> {

}
