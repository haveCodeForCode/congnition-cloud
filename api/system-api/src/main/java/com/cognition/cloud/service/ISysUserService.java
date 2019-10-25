package com.cognition.cloud.service;

import com.cognition.cloud.entity.SysUser;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 用户 业务层
 *
 * @author 1122
 */
@FeignClient(value = "ISysUserService")
public interface ISysUserService {

    /**
     * 根据条件分页查询用户列表
     *
     * @param user 用户信息
     * @return 用户信息集合信息
     */
    @GetMapping(value = "/ISysUserService/selectUserList")
    public List<SysUser> selectUserList(@RequestParam("user") SysUser user);

    /**
     * 根据条件分页查询已分配用户角色列表
     *
     * @param user 用户信息
     * @return 用户信息集合信息
     */
    @GetMapping(value = "/ISysUserService/selectUserList")
    public List<SysUser> selectAllocatedList(@RequestParam("user") SysUser user);

    /**
     * 根据条件分页查询未分配用户角色列表
     *
     * @param user 用户信息
     * @return 用户信息集合信息
     */
    @GetMapping(value = "/ISysUserService/selectUnallocatedList")
    public List<SysUser> selectUnallocatedList(@RequestParam("user") SysUser user);

    /**
     * 通过用户名查询用户
     *
     * @param userName 用户名
     * @return 用户对象信息
     */
    @GetMapping(value = "/ISysUserService/selectUserByLoginName")
    public SysUser selectUserByLoginName(@RequestParam("userName") String userName);

    /**
     * 通过手机号码查询用户
     *
     * @param phoneNumber 手机号码
     * @return 用户对象信息
     */
    @GetMapping(value = "/ISysUserService/selectUserByPhoneNumber")
    public SysUser selectUserByPhoneNumber(@RequestParam("phoneNumber") String phoneNumber);

    /**
     * 通过邮箱查询用户
     *
     * @param email 邮箱
     * @return 用户对象信息
     */
    @GetMapping(value = "/ISysUserService/selectUserByEmail")
    public SysUser selectUserByEmail(@RequestParam("email") String email);

    /**
     * 通过用户ID查询用户
     *
     * @param userId 用户ID
     * @return 用户对象信息
     */
    @GetMapping(value = "/ISysUserService/selectUserById")
    public SysUser selectUserById(@RequestParam("userId") Long userId);

    /**
     * 通过用户ID删除用户
     *
     * @param userId 用户ID
     * @return 结果
     */
    @GetMapping(value = "/ISysUserService/deleteUserById")
    public int deleteUserById(@RequestParam("userId") Long userId);

    /**
     * 批量删除用户信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     * @throws Exception 异常
     */
    @GetMapping(value = "/ISysUserService/deleteUserByIds")
    public int deleteUserByIds(@RequestParam("ids") String ids) throws Exception;

    /**
     * 保存用户信息
     *
     * @param user 用户信息
     * @return 结果
     */
    @GetMapping(value = "/ISysUserService/insertUser")
    public int insertUser(@RequestParam("user") SysUser user);

    /**
     * 保存用户信息
     *
     * @param user 用户信息
     * @return 结果
     */
    @GetMapping(value = "/ISysUserService/updateUser")
    public int updateUser(@RequestParam("user") SysUser user);

    /**
     * 修改用户详细信息
     *
     * @param user 用户信息
     * @return 结果
     */
    @GetMapping(value = "/ISysUserService/updateUserInfo")
    public int updateUserInfo(@RequestParam("user") SysUser user);

    /**
     * 修改用户密码信息
     *
     * @param user 用户信息
     * @return 结果
     */
    @GetMapping(value = "/ISysUserService/resetUserPwd")
    public int resetUserPwd(@RequestParam("user") SysUser user);

    /**
     * 校验用户名称是否唯一
     *
     * @param loginName 登录名称
     * @return 结果
     */
    @GetMapping(value = "/ISysUserService/checkLoginNameUnique")
    public String checkLoginNameUnique(@RequestParam("loginName") String loginName);

    /**
     * 校验手机号码是否唯一
     *
     * @param user 用户信息
     * @return 结果
     */
    @GetMapping(value = "/ISysUserService/checkPhoneUnique")
    public String checkPhoneUnique(@RequestParam("user") SysUser user);

    /**
     * 校验email是否唯一
     *
     * @param user 用户信息
     * @return 结果
     */
    @GetMapping(value = "/ISysUserService/checkEmailUnique")
    public String checkEmailUnique(@RequestParam("user") SysUser user);

    /**
     * 校验用户是否允许操作
     *
     * @param user 用户信息
     */
    @GetMapping(value = "/ISysUserService/checkUserAllowed")
    public void checkUserAllowed(@RequestParam("user") SysUser user);

    /**
     * 根据用户ID查询用户所属角色组
     *
     * @param userId 用户ID
     * @return 结果
     */
    @GetMapping(value = "/ISysUserService/selectUserRoleGroup")
    public String selectUserRoleGroup(@RequestParam("userId") Long userId);

    /**
     * 根据用户ID查询用户所属岗位组
     *
     * @param userId 用户ID
     * @return 结果
     */
    @GetMapping(value = "/ISysUserService/selectUserRoleGroup")
    public String selectUserPostGroup(@RequestParam("userId") Long userId);

    /**
     * 导入用户数据
     *
     * @param userList        用户数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName        操作用户
     * @return 结果
     */
    @GetMapping(value = "/ISysUserService/importUser")
    public String importUser(@RequestParam("userList") List<SysUser> userList, @RequestParam("isUpdateSupport") Boolean isUpdateSupport, @RequestParam("operName") String operName);

    /**
     * 用户状态修改
     *
     * @param user 用户信息
     * @return 结果
     */
    @GetMapping(value = "/ISysUserService/changeStatus")
    public int changeStatus(@RequestParam("user") SysUser user);
}
