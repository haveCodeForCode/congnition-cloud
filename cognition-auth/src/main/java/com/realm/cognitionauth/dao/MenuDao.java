package com.realm.cognitionauth.dao;


import com.realm.cognitionauth.entity.Menu;
import com.realm.cognitioncommon.persistence.BaseDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 菜单管理
 *
 * @author LineInkBook
 */
@Repository("MenuDao")
public interface MenuDao extends JpaRepository<Menu,Long> {


}
