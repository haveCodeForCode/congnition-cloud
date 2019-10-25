package com.cognitioncloud.system.service.impl;

import com.realm.cognitioncommon.text.Convert;
import com.realm.cognitiondomain.system.SysDictData;
import com.realm.cognitionsystem.dao.SysDictDataDao;
import com.realm.cognitionsystem.service.ISysDictDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 字典 业务层处理
 *
 * @author 1122
 */
@Service
public class SysDictDataServiceImpl implements ISysDictDataService {


    private SysDictDataDao sysDictDataDao;

    @Autowired
    public void setSysDictDataDao(SysDictDataDao sysDictDataDao) {
        this.sysDictDataDao = sysDictDataDao;
    }

    /**
     * 根据条件分页查询字典数据
     * 
     * @param dictData 字典数据信息
     * @return 字典数据集合信息
     */
    @Override
    public List<SysDictData> selectDictDataList(SysDictData dictData) {
        return sysDictDataDao.selectDictDataList(dictData);
    }

    /**
     * 根据字典类型查询字典数据
     * 
     * @param dictType 字典类型
     * @return 字典数据集合信息
     */
    @Override
    public List<SysDictData> selectDictDataByType(String dictType) {
        return sysDictDataDao.selectDictDataByType(dictType);
    }

    /**
     * 根据字典类型和字典键值查询字典数据信息
     * 
     * @param dictType 字典类型
     * @param dictValue 字典键值
     * @return 字典标签
     */
    @Override
    public String selectDictLabel(String dictType, String dictValue) {
        return sysDictDataDao.selectDictLabel(dictType, dictValue);
    }

    /**
     * 根据字典数据ID查询信息
     * 
     * @param dictCode 字典数据ID
     * @return 字典数据
     */
    @Override
    public SysDictData selectDictDataById(Long dictCode) {
        return sysDictDataDao.selectDictDataById(dictCode);
    }

    /**
     * 通过字典ID删除字典数据信息
     * 
     * @param dictCode 字典数据ID
     * @return 结果
     */
    @Override
    public int deleteDictDataById(Long dictCode) {
        return sysDictDataDao.deleteDictDataById(dictCode);
    }

    /**
     * 批量删除字典数据
     * 
     * @param ids 需要删除的数据
     * @return 结果
     */
    @Override
    public int deleteDictDataByIds(String ids) {
        return sysDictDataDao.deleteDictDataByIds(Convert.toStrArray(ids));
    }

    /**
     * 新增保存字典数据信息
     * 
     * @param dictData 字典数据信息
     * @return 结果
     */
    @Override
    public int insertDictData(SysDictData dictData) {
        return sysDictDataDao.insertDictData(dictData);
    }

    /**
     * 修改保存字典数据信息
     * 
     * @param dictData 字典数据信息
     * @return 结果
     */
    @Override
    public int updateDictData(SysDictData dictData) {
        return sysDictDataDao.updateDictData(dictData);
    }
}
