package com.realm.cognitionadmin.dao;

import com.realm.cognitionadmin.entity.Role;
import com.realm.cognitioncommon.persistence.BaseDao;
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
public interface RoleDao extends BaseDao<Role> {

    /**
     * 根据用户id查询角色表
     * @param params
     * @return
     */
    List<Role> findWithUserId(Map<String, Object> params);
}
