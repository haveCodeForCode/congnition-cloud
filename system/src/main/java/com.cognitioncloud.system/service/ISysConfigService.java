package com.cognitioncloud.system.service;

import com.cognitioncloud.api.entity.system.SysConfig;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * 参数配置 服务层
 *
 * @author 1122
 */
@FeignClient(value = "ISysConfigService")
public interface ISysConfigService {
    /**
     * 查询参数配置信息
     *
     * @param configId 参数配置ID
     * @return 参数配置信息
     */
    @GetMapping(value = "/ISysConfigService/selectConfigById")
    public SysConfig selectConfigById(Long configId);

    /**
     * 根据键名查询参数配置信息
     *
     * @param configKey 参数键名
     * @return 参数键值
     */
    @GetMapping(value = "/ISysConfigService/selectConfigByKey")
    public String selectConfigByKey(String configKey);

    /**
     * 查询参数配置列表
     *
     * @param config 参数配置信息
     * @return 参数配置集合
     */
    @GetMapping(value = "/ISysConfigService/selectConfigList")
    public List<SysConfig> selectConfigList(SysConfig config);

    /**
     * 新增参数配置
     *
     * @param config 参数配置信息
     * @return 结果
     */
    @GetMapping(value = "/configService/insertConfig")
    public int insertConfig(SysConfig config);

    /**
     * 修改参数配置
     *
     * @param config 参数配置信息
     * @return 结果
     */
    @GetMapping(value = "/ISysConfigService/insertConfig")
    public int updateConfig(SysConfig config);

    /**
     * 批量删除参数配置信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @GetMapping(value = "/ISysConfigService/deleteConfigByIds")
    public int deleteConfigByIds(String ids);

    /**
     * 校验参数键名是否唯一
     *
     * @param config 参数信息
     * @return 结果
     */
    @GetMapping(value = "/ISysConfigService/checkConfigKeyUnique")
    public String checkConfigKeyUnique(SysConfig config);
}
