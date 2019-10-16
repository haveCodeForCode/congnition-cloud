package com.realm.cognitionauth.service.impl;


import com.realm.cognitionauth.dao.SysPostDao;
import com.realm.cognitionauth.dao.SysUserPostDao;
import com.realm.cognitionauth.entity.SysPost;
import com.realm.cognitionauth.service.ISysPostService;
import com.realm.cognitioncommon.constant.Constants;
import com.realm.cognitioncommon.exception.BusinessException;
import com.realm.cognitioncommon.text.Convert;
import com.realm.cognitioncommon.until.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 岗位信息 服务层处理
 * 
 * @author 1122
 */
@Service
public class SysPostServiceImpl implements ISysPostService {

    private SysPostDao sysPostDao;
    private SysUserPostDao userPostDao;

    @Autowired
    public void setSysPostDao(SysPostDao sysPostDao) {
        this.sysPostDao = sysPostDao;
    }

    @Autowired
    public void setUserPostDao(SysUserPostDao userPostDao) {
        this.userPostDao = userPostDao;
    }

    /**
     * 查询岗位信息集合
     * 
     * @param post 岗位信息
     * @return 岗位信息集合
     */
    @Override
    public List<SysPost> selectPostList(SysPost post) {
        return sysPostDao.selectPostList(post);
    }

    /**
     * 查询所有岗位
     * 
     * @return 岗位列表
     */
    @Override
    public List<SysPost> selectPostAll() {
        return sysPostDao.selectPostAll();
    }

    /**
     * 根据用户ID查询岗位
     * 
     * @param userId 用户ID
     * @return 岗位列表
     */
    @Override
    public List<SysPost> selectPostsByUserId(Long userId) {
        List<SysPost> userPosts = sysPostDao.selectPostsByUserId(userId);
        List<SysPost> posts = sysPostDao.selectPostAll();
        for (SysPost post : posts) {
            for (SysPost userRole : userPosts) {
                if (post.getPostId().longValue() == userRole.getPostId().longValue()) {
                    post.setFlag(true);
                    break;
                }
            }
        }
        return posts;
    }

    /**
     * 通过岗位ID查询岗位信息
     * 
     * @param postId 岗位ID
     * @return 角色对象信息
     */
    @Override
    public SysPost selectPostById(Long postId) {
        return sysPostDao.selectPostById(postId);
    }

    /**
     * 批量删除岗位信息
     * 
     * @param ids 需要删除的数据ID
     * @throws Exception
     */
    @Override
    public int deletePostByIds(String ids) throws BusinessException {
        Long[] postIds = Convert.toLongArray(ids);
        for (Long postId : postIds)
        {
            SysPost post = selectPostById(postId);
            if (countUserPostById(postId) > 0) {
                throw new BusinessException(String.format("%1$s已分配,不能删除", post.getPostName()));
            }
        }
        return sysPostDao.deletePostByIds(postIds);
    }

    /**
     * 新增保存岗位信息
     * 
     * @param post 岗位信息
     * @return 结果
     */
    @Override
    public int insertPost(SysPost post) {
        return sysPostDao.insertPost(post);
    }

    /**
     * 修改保存岗位信息
     * 
     * @param post 岗位信息
     * @return 结果
     */
    @Override
    public int updatePost(SysPost post) {
        return sysPostDao.updatePost(post);
    }

    /**
     * 通过岗位ID查询岗位使用数量
     * 
     * @param postId 岗位ID
     * @return 结果
     */
    @Override
    public int countUserPostById(Long postId) {
        return userPostDao.countUserPostById(postId);
    }

    /**
     * 校验岗位名称是否唯一
     * 
     * @param post 岗位信息
     * @return 结果
     */
    @Override
    public String checkPostNameUnique(SysPost post) {
        Long postId = StringUtils.isNull(post.getPostId()) ? -1L : post.getPostId();
        SysPost info = sysPostDao.checkPostNameUnique(post.getPostName());
        if (StringUtils.isNotNull(info) && info.getPostId().longValue() != postId.longValue()) {
            return Constants.POST_NAME_NOT_UNIQUE;
        }
        return Constants.POST_NAME_UNIQUE;
    }

    /**
     * 校验岗位编码是否唯一
     * 
     * @param post 岗位信息
     * @return 结果
     */
    @Override
    public String checkPostCodeUnique(SysPost post) {
        Long postId = StringUtils.isNull(post.getPostId()) ? -1L : post.getPostId();
        SysPost info = sysPostDao.checkPostCodeUnique(post.getPostCode());
        if (StringUtils.isNotNull(info) && info.getPostId().longValue() != postId.longValue()) {
            return Constants.POST_CODE_NOT_UNIQUE;
        }
        return Constants.POST_CODE_UNIQUE;
    }
}
