package com.cognitioncloud.system.service.impl;


import com.realm.cognitioncommon.text.Convert;
import com.realm.cognitiondomain.system.SysLogininfor;
import com.realm.cognitionsystem.dao.SysLogininforDao;
import com.realm.cognitionsystem.service.ISysLogininforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 系统访问日志情况信息 服务层处理
 *
 * @author 1122
 */
@Service
public class SysLogininforServiceImpl implements ISysLogininforService {


    private SysLogininforDao logininforDao;

    @Autowired
    public void setLogininforMapper(SysLogininforDao logininforDao) {
        this.logininforDao = logininforDao;
    }

    /**
     * 新增系统登录日志
     * 
     * @param logininfor 访问日志对象
     */
    @Override
    public void insertLogininfor(SysLogininfor logininfor) {
        logininforDao.insertLogininfor(logininfor);
    }

    /**
     * 查询系统登录日志集合
     * 
     * @param logininfor 访问日志对象
     * @return 登录记录集合
     */
    @Override
    public List<SysLogininfor> selectLogininforList(SysLogininfor logininfor) {
        return logininforDao.selectLogininforList(logininfor);
    }

    /**
     * 批量删除系统登录日志
     * 
     * @param ids 需要删除的数据
     * @return
     */
    @Override
    public int deleteLogininforByIds(String ids) {
        return logininforDao.deleteLogininforByIds(Convert.toStrArray(ids));
    }

    /**
     * 清空系统登录日志
     */
    @Override
    public void cleanLogininfor() {
        logininforDao.cleanLogininfor();
    }
}
