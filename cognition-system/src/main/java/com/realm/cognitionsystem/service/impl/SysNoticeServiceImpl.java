package com.realm.cognitionsystem.service.impl;

import com.realm.cognitionsystem.dao.SysNoticeDao;
import com.realm.cognitionsystem.entity.SysNotice;
import com.realm.cognitionsystem.service.ISysNoticeService;
import com.realm.cognitioncommon.text.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 公告 服务层实现
 *
 * @author 1122
 * @date 2018-06-25
 */
@Service
public class SysNoticeServiceImpl implements ISysNoticeService {

    private SysNoticeDao sysNoticeDao;

    @Autowired
    public void setSysNoticeDao(SysNoticeDao sysNoticeDao) {
        this.sysNoticeDao = sysNoticeDao;
    }

    /**
     * 查询公告信息
     *
     * @param noticeId 公告ID
     * @return 公告信息
     */
    @Override
    public SysNotice selectNoticeById(Long noticeId) {
        return sysNoticeDao.selectNoticeById(noticeId);
    }

    /**
     * 查询公告列表
     *
     * @param notice 公告信息
     * @return 公告集合
     */
    @Override
    public List<SysNotice> selectNoticeList(SysNotice notice) {
        return sysNoticeDao.selectNoticeList(notice);
    }

    /**
     * 新增公告
     *
     * @param notice 公告信息
     * @return 结果
     */
    @Override
    public int insertNotice(SysNotice notice) {
        return sysNoticeDao.insertNotice(notice);
    }

    /**
     * 修改公告
     *
     * @param notice 公告信息
     * @return 结果
     */
    @Override
    public int updateNotice(SysNotice notice) {
        return sysNoticeDao.updateNotice(notice);
    }

    /**
     * 删除公告对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteNoticeByIds(String ids) {
        return sysNoticeDao.deleteNoticeByIds(Convert.toStrArray(ids));
    }
}
