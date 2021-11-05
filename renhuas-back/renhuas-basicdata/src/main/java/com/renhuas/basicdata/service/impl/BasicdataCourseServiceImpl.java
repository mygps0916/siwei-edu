package com.renhuas.basicdata.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.renhuas.basicdata.mapper.BasicdataCourseMapper;
import com.renhuas.basicdata.domain.BasicdataCourse;
import com.renhuas.basicdata.service.IBasicdataCourseService;

/**
 * 科目信息Service业务层处理
 * 
 * @author chenzr
 * @date 2021-11-04
 */
@Service
public class BasicdataCourseServiceImpl implements IBasicdataCourseService 
{
    @Autowired
    private BasicdataCourseMapper basicdataCourseMapper;

    /**
     * 查询科目信息
     * 
     * @param courseId 科目信息主键
     * @return 科目信息
     */
    @Override
    public BasicdataCourse selectBasicdataCourseByCourseId(Long courseId)
    {
        return basicdataCourseMapper.selectBasicdataCourseByCourseId(courseId);
    }

    /**
     * 查询科目信息列表
     * 
     * @param basicdataCourse 科目信息
     * @return 科目信息
     */
    @Override
    public List<BasicdataCourse> selectBasicdataCourseList(BasicdataCourse basicdataCourse)
    {
        return basicdataCourseMapper.selectBasicdataCourseList(basicdataCourse);
    }

    /**
     * 新增科目信息
     * 
     * @param basicdataCourse 科目信息
     * @return 结果
     */
    @Override
    public int insertBasicdataCourse(BasicdataCourse basicdataCourse)
    {
        return basicdataCourseMapper.insertBasicdataCourse(basicdataCourse);
    }

    /**
     * 修改科目信息
     * 
     * @param basicdataCourse 科目信息
     * @return 结果
     */
    @Override
    public int updateBasicdataCourse(BasicdataCourse basicdataCourse)
    {
        return basicdataCourseMapper.updateBasicdataCourse(basicdataCourse);
    }

    /**
     * 批量删除科目信息
     * 
     * @param courseIds 需要删除的科目信息主键
     * @return 结果
     */
    @Override
    public int deleteBasicdataCourseByCourseIds(Long[] courseIds)
    {
        return basicdataCourseMapper.deleteBasicdataCourseByCourseIds(courseIds);
    }

    /**
     * 删除科目信息信息
     * 
     * @param courseId 科目信息主键
     * @return 结果
     */
    @Override
    public int deleteBasicdataCourseByCourseId(Long courseId)
    {
        return basicdataCourseMapper.deleteBasicdataCourseByCourseId(courseId);
    }
}
