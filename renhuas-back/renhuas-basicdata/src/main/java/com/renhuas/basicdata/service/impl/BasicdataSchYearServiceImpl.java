package com.renhuas.basicdata.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.renhuas.basicdata.mapper.BasicdataSchYearMapper;
import com.renhuas.basicdata.domain.BasicdataSchYear;
import com.renhuas.basicdata.service.IBasicdataSchYearService;

/**
 * 学年信息Service业务层处理
 * 
 * @author chenzr
 * @date 2021-11-04
 */
@Service
public class BasicdataSchYearServiceImpl implements IBasicdataSchYearService 
{
    @Autowired
    private BasicdataSchYearMapper basicdataSchYearMapper;

    /**
     * 查询学年信息
     * 
     * @param schYearId 学年信息主键
     * @return 学年信息
     */
    @Override
    public BasicdataSchYear selectBasicdataSchYearBySchYearId(Long schYearId)
    {
        return basicdataSchYearMapper.selectBasicdataSchYearBySchYearId(schYearId);
    }

    /**
     * 查询学年信息列表
     * 
     * @param basicdataSchYear 学年信息
     * @return 学年信息
     */
    @Override
    public List<BasicdataSchYear> selectBasicdataSchYearList(BasicdataSchYear basicdataSchYear)
    {
        return basicdataSchYearMapper.selectBasicdataSchYearList(basicdataSchYear);
    }

    /**
     * 新增学年信息
     * 
     * @param basicdataSchYear 学年信息
     * @return 结果
     */
    @Override
    public int insertBasicdataSchYear(BasicdataSchYear basicdataSchYear)
    {
        return basicdataSchYearMapper.insertBasicdataSchYear(basicdataSchYear);
    }

    /**
     * 修改学年信息
     * 
     * @param basicdataSchYear 学年信息
     * @return 结果
     */
    @Override
    public int updateBasicdataSchYear(BasicdataSchYear basicdataSchYear)
    {
        return basicdataSchYearMapper.updateBasicdataSchYear(basicdataSchYear);
    }

    /**
     * 批量删除学年信息
     * 
     * @param schYearIds 需要删除的学年信息主键
     * @return 结果
     */
    @Override
    public int deleteBasicdataSchYearBySchYearIds(Long[] schYearIds)
    {
        return basicdataSchYearMapper.deleteBasicdataSchYearBySchYearIds(schYearIds);
    }

    /**
     * 删除学年信息信息
     * 
     * @param schYearId 学年信息主键
     * @return 结果
     */
    @Override
    public int deleteBasicdataSchYearBySchYearId(Long schYearId)
    {
        return basicdataSchYearMapper.deleteBasicdataSchYearBySchYearId(schYearId);
    }
}
