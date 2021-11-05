package com.renhuas.basicdata.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.renhuas.basicdata.mapper.BasicdataSchTypeMapper;
import com.renhuas.basicdata.domain.BasicdataSchType;
import com.renhuas.basicdata.service.IBasicdataSchTypeService;

/**
 * 学校类型Service业务层处理
 * 
 * @author chenzr
 * @date 2021-11-04
 */
@Service
public class BasicdataSchTypeServiceImpl implements IBasicdataSchTypeService 
{
    @Autowired
    private BasicdataSchTypeMapper basicdataSchTypeMapper;

    /**
     * 查询学校类型
     * 
     * @param schTypeId 学校类型主键
     * @return 学校类型
     */
    @Override
    public BasicdataSchType selectBasicdataSchTypeBySchTypeId(Long schTypeId)
    {
        return basicdataSchTypeMapper.selectBasicdataSchTypeBySchTypeId(schTypeId);
    }

    /**
     * 查询学校类型列表
     * 
     * @param basicdataSchType 学校类型
     * @return 学校类型
     */
    @Override
    public List<BasicdataSchType> selectBasicdataSchTypeList(BasicdataSchType basicdataSchType)
    {
        return basicdataSchTypeMapper.selectBasicdataSchTypeList(basicdataSchType);
    }

    /**
     * 新增学校类型
     * 
     * @param basicdataSchType 学校类型
     * @return 结果
     */
    @Override
    public int insertBasicdataSchType(BasicdataSchType basicdataSchType)
    {
        return basicdataSchTypeMapper.insertBasicdataSchType(basicdataSchType);
    }

    /**
     * 修改学校类型
     * 
     * @param basicdataSchType 学校类型
     * @return 结果
     */
    @Override
    public int updateBasicdataSchType(BasicdataSchType basicdataSchType)
    {
        return basicdataSchTypeMapper.updateBasicdataSchType(basicdataSchType);
    }

    /**
     * 批量删除学校类型
     * 
     * @param schTypeIds 需要删除的学校类型主键
     * @return 结果
     */
    @Override
    public int deleteBasicdataSchTypeBySchTypeIds(Long[] schTypeIds)
    {
        return basicdataSchTypeMapper.deleteBasicdataSchTypeBySchTypeIds(schTypeIds);
    }

    /**
     * 删除学校类型信息
     * 
     * @param schTypeId 学校类型主键
     * @return 结果
     */
    @Override
    public int deleteBasicdataSchTypeBySchTypeId(Long schTypeId)
    {
        return basicdataSchTypeMapper.deleteBasicdataSchTypeBySchTypeId(schTypeId);
    }
}
