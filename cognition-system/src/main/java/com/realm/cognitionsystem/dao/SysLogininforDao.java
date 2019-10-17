package com.realm.cognitionsystem.dao;


import com.realm.cognitionsystem.entity.SysLogininfor;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 系统访问日志情况信息 数据层
 *
 * @author 1122
 */
@Mapper
@Repository("SysLogininforDao")
public interface SysLogininforDao {

    /**
     * 新增系统登录日志
     * 
     * @param logininfor 访问日志对象
     */
    public void insertLogininfor(SysLogininfor logininfor);

    /**
     * 查询系统登录日志集合
     * 
     * @param logininfor 访问日志对象
     * @return 登录记录集合
     */
    public List<SysLogininfor> selectLogininforList(SysLogininfor logininfor);

    /**
     * 批量删除系统登录日志
     * 
     * @param ids 需要删除的数据
     * @return 结果
     */
    public int deleteLogininforByIds(String[] ids);

    /**
     * 清空系统登录日志
     * 
     * @return 结果
     */
    public int cleanLogininfor();
}
