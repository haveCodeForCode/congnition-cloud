package com.root.cognition.system.dao;

import com.root.cognition.system.entity.User;
import com.root.cognition.common.persistence.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


/**
 * @author 王睿
 * @version 2018/12/24
 */
@Mapper
@Repository("UserDao")
public interface UserDao extends BaseDao<User> {

    /**
     * 通过id获取user与Role
     * 其中Role
     * @param id
     * @return
     */
    User getWithRole (String id);
}
