package com.renhuas.basicdata.service;

import java.util.List;
import com.renhuas.basicdata.domain.BasicdataSchYear;

/**
 * 学年信息Service接口
 * 
 * @author chenzr
 * @date 2021-11-04
 */
public interface IBasicdataSchYearService 
{
    /**
     * 查询学年信息
     * 
     * @param schYearId 学年信息主键
     * @return 学年信息
     */
    public BasicdataSchYear selectBasicdataSchYearBySchYearId(Long schYearId);

    /**
     * 查询学年信息列表
     * 
     * @param basicdataSchYear 学年信息
     * @return 学年信息集合
     */
    public List<BasicdataSchYear> selectBasicdataSchYearList(BasicdataSchYear basicdataSchYear);

    /**
     * 新增学年信息
     * 
     * @param basicdataSchYear 学年信息
     * @return 结果
     */
    public int insertBasicdataSchYear(BasicdataSchYear basicdataSchYear);

    /**
     * 修改学年信息
     * 
     * @param basicdataSchYear 学年信息
     * @return 结果
     */
    public int updateBasicdataSchYear(BasicdataSchYear basicdataSchYear);

    /**
     * 批量删除学年信息
     * 
     * @param schYearIds 需要删除的学年信息主键集合
     * @return 结果
     */
    public int deleteBasicdataSchYearBySchYearIds(Long[] schYearIds);

    /**
     * 删除学年信息信息
     * 
     * @param schYearId 学年信息主键
     * @return 结果
     */
    public int deleteBasicdataSchYearBySchYearId(Long schYearId);
}
