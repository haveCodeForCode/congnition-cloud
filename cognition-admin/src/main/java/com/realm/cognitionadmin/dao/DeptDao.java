package com.realm.cognitionadmin.dao;

import com.realm.cognitionadmin.entity.Dept;
import com.realm.cognitioncommon.persistence.BaseDao;
import org.springframework.stereotype.Repository;


/**
 * 部门管理
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-10-03 15:35:39
 */

@Repository("DeptDao")
public interface DeptDao extends BaseDao<Dept> {

	/**
	 * 查询父级部门
	 *
	 * @return
	 */
	String[] listParentDept();

	/**
	 * 查询全部相关部门
	 *
	 * @return
	 */
	String[] listAllDept();
}
