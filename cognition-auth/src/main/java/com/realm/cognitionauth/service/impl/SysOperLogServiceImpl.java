package com.realm.cognitionauth.service.impl;

import com.realm.cognitionauth.dao.SysOperLogDao;
import com.realm.cognitionauth.entity.SysOperLog;
import com.realm.cognitionauth.service.ISysOperLogService;
import com.realm.cognitioncommon.text.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 操作日志 服务层处理
 *
 * @author 1122
 */
@Service
public class SysOperLogServiceImpl implements ISysOperLogService {


    private SysOperLogDao sysOperLogDao;

    @Autowired
    public void setSysOperLogDao(SysOperLogDao sysOperLogDao) {
        this.sysOperLogDao = sysOperLogDao;
    }

    /**
     * 新增操作日志
     *
     * @param operLog 操作日志对象
     */
    @Override
    public void insertOperlog(SysOperLog operLog) {
        sysOperLogDao.insertOperlog(operLog);
    }

    /**
     * 查询系统操作日志集合
     *
     * @param operLog 操作日志对象
     * @return 操作日志集合
     */
    @Override
    public List<SysOperLog> selectOperLogList(SysOperLog operLog) {
        return sysOperLogDao.selectOperLogList(operLog);
    }

    /**
     * 批量删除系统操作日志
     *
     * @param ids 需要删除的数据
     * @return
     */
    @Override
    public int deleteOperLogByIds(String ids) {
        return sysOperLogDao.deleteOperLogByIds(Convert.toStrArray(ids));
    }

    /**
     * 查询操作日志详细
     *
     * @param operId 操作ID
     * @return 操作日志对象
     */
    @Override
    public SysOperLog selectOperLogById(Long operId) {
        return sysOperLogDao.selectOperLogById(operId);
    }

    /**
     * 清空操作日志
     */
    @Override
    public void cleanOperLog() {
        sysOperLogDao.cleanOperLog();
    }
}
