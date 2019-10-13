package com.realm.cognitionauth.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户
 * @author taoya
 */
@Entity(name = "UserRole")
@Table(name = "sys_user_role")
public class UserRole {
    /**
     * 关联表主键
     * <p>
     * id
     */
    @Id
    private Long id;
    /**
     * 用户主键
     * <p>
     * userId
     */
    private Long userId;
    /**
     * 角色主键
     * <p>
     *  roleId
     */
    private Long roleId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "UserRoleDO{" +
                "id=" + id +
                ", userId=" + userId +
                ", roleId=" + roleId +
                '}';
    }
}
