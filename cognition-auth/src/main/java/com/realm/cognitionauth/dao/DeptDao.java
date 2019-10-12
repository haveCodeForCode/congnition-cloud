package com.realm.cognitionauth.dao;

import com.realm.cognitionauth.entity.Dept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * 部门管理
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-10-03 15:35:39
 */

@Repository("DeptDao")
public interface DeptDao extends JpaRepository<Dept,Long> {


}
