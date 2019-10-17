package com.realm.cognitionsystem.dao;


import com.realm.cognitionsystem.entity.SysNotice;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 公告 数据层
 * 
 * @author 1122
 */
@Mapper
@Repository("SysNoticeDao")
public interface SysNoticeDao {

    /**
     * 查询公告信息
     * 
     * @param noticeId 公告ID
     * @return 公告信息
     */
    public SysNotice selectNoticeById(Long noticeId);

    /**
     * 查询公告列表
     * 
     * @param notice 公告信息
     * @return 公告集合
     */
    public List<SysNotice> selectNoticeList(SysNotice notice);

    /**
     * 新增公告
     * 
     * @param notice 公告信息
     * @return 结果
     */
    public int insertNotice(SysNotice notice);

    /**
     * 修改公告
     * 
     * @param notice 公告信息
     * @return 结果
     */
    public int updateNotice(SysNotice notice);

    /**
     * 批量删除公告
     * 
     * @param noticeIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteNoticeByIds(String[] noticeIds);
}