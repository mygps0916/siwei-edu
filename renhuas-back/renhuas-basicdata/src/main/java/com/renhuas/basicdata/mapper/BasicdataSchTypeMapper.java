package com.renhuas.basicdata.mapper;

import java.util.List;
import com.renhuas.basicdata.domain.BasicdataSchType;

/**
 * 学校类型Mapper接口
 * 
 * @author chenzr
 * @date 2021-11-04
 */
public interface BasicdataSchTypeMapper 
{
    /**
     * 查询学校类型
     * 
     * @param schTypeId 学校类型主键
     * @return 学校类型
     */
    public BasicdataSchType selectBasicdataSchTypeBySchTypeId(Long schTypeId);

    /**
     * 查询学校类型列表
     * 
     * @param basicdataSchType 学校类型
     * @return 学校类型集合
     */
    public List<BasicdataSchType> selectBasicdataSchTypeList(BasicdataSchType basicdataSchType);

    /**
     * 新增学校类型
     * 
     * @param basicdataSchType 学校类型
     * @return 结果
     */
    public int insertBasicdataSchType(BasicdataSchType basicdataSchType);

    /**
     * 修改学校类型
     * 
     * @param basicdataSchType 学校类型
     * @return 结果
     */
    public int updateBasicdataSchType(BasicdataSchType basicdataSchType);

    /**
     * 删除学校类型
     * 
     * @param schTypeId 学校类型主键
     * @return 结果
     */
    public int deleteBasicdataSchTypeBySchTypeId(Long schTypeId);

    /**
     * 批量删除学校类型
     * 
     * @param schTypeIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBasicdataSchTypeBySchTypeIds(Long[] schTypeIds);
}
