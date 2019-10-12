package com.realm.cognitionauth.dao;

import com.realm.cognitionauth.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 角色
 *
 * @author warry
 * @date 2017-10-02 20:24:47
 */
@Repository("RoleDao")
public interface RoleDao extends JpaRepository<Role,Long> {

}
