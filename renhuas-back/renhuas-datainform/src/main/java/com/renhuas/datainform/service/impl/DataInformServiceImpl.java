package com.renhuas.datainform.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.renhuas.datainform.mapper.DataInformMapper;
import com.renhuas.datainform.domain.DataInform;
import com.renhuas.datainform.service.IDataInformService;

/**
 * 数据管理Service业务层处理
 * 
 * @author chenzr
 * @date 2021-11-04
 */
@Service
public class DataInformServiceImpl implements IDataInformService 
{
    @Autowired
    private DataInformMapper dataInformMapper;

    /**
     * 查询数据管理
     * 
     * @param inforId 数据管理主键
     * @return 数据管理
     */
    @Override
    public DataInform selectDataInformByInforId(Long inforId)
    {
        return dataInformMapper.selectDataInformByInforId(inforId);
    }

    /**
     * 查询数据管理列表
     * 
     * @param dataInform 数据管理
     * @return 数据管理
     */
    @Override
    public List<DataInform> selectDataInformList(DataInform dataInform)
    {
        return dataInformMapper.selectDataInformList(dataInform);
    }

    /**
     * 新增数据管理
     * 
     * @param dataInform 数据管理
     * @return 结果
     */
    @Override
    public int insertDataInform(DataInform dataInform)
    {
        return dataInformMapper.insertDataInform(dataInform);
    }

    /**
     * 修改数据管理
     * 
     * @param dataInform 数据管理
     * @return 结果
     */
    @Override
    public int updateDataInform(DataInform dataInform)
    {
        return dataInformMapper.updateDataInform(dataInform);
    }

    /**
     * 批量删除数据管理
     * 
     * @param inforIds 需要删除的数据管理主键
     * @return 结果
     */
    @Override
    public int deleteDataInformByInforIds(Long[] inforIds)
    {
        return dataInformMapper.deleteDataInformByInforIds(inforIds);
    }

    /**
     * 删除数据管理信息
     * 
     * @param inforId 数据管理主键
     * @return 结果
     */
    @Override
    public int deleteDataInformByInforId(Long inforId)
    {
        return dataInformMapper.deleteDataInformByInforId(inforId);
    }
}
