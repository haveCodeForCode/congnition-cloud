package com.realm.cognitionauth.dao;

import com.realm.cognitionauth.entity.RoleMenu;
import com.realm.cognitioncommon.persistence.BaseDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 王睿
 * @version 2019/2/19
 */
@Repository("RoleMenuDao")
public interface RoleMenuDao extends JpaRepository<RoleMenu,Long> {

}
