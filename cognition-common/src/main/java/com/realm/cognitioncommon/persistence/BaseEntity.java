/**
 *
 */
package com.realm.cognitioncommon.persistence;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;



/**
 * Entity支持类
 * @author warry
 * @version 2014-05-16
 */
public abstract class BaseEntity<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 搜索值
     */
    private String searchValue;

    /**
     * 创建者
     */
    private String createBy;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 更新者
     */
    private String updateBy;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    private String delFlag;
    /**
     * 请求参数
     */
    private Map<String, Object> params;

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


    public Map<String, Object> getParams() {
        if (params == null) {
            params = new HashMap<>();
        }
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    @Length(min = 1, max = 1)
    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }


//    /**
//     * 是否是新记录（默认：false），调用setIsNewRecord()设置新记录，使用自定义ID。
//     * 设置为true后强制执行插入语句，ID不会自动生成，需从手动传入。
//     */
//    protected boolean isNewRecord = false;

//	@JsonIgnore
//	@XmlTransient
//	public Map<String, String> getSqlMap() {
//		if (sqlMap == null){
//			sqlMap = Maps.newHashMap();
//		}
//		return sqlMap;
//	}


    /**
     * 预插入数据补充
     */
//    public void preInsert() {
//        // 不限制ID为UUID，调用setIsNewRecord()使用自定义ID
//        Long sfUserID = SnowFlake.createSFid();
//        setId(sfUserID);
//        this.updateBy = sfUserID;
//        this.createBy = sfUserID;
//        this.createTime = new Date();
//        this.updateTime = createTime;
//        this.delFlag = Constant.DEL_FLAG_NORMAL;
//    }

}
