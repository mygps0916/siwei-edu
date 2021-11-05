package com.renhuas.basicdata.service;

import java.util.List;
import com.renhuas.basicdata.domain.BasicdataCourse;

/**
 * 科目信息Service接口
 * 
 * @author chenzr
 * @date 2021-11-04
 */
public interface IBasicdataCourseService 
{
    /**
     * 查询科目信息
     * 
     * @param courseId 科目信息主键
     * @return 科目信息
     */
    public BasicdataCourse selectBasicdataCourseByCourseId(Long courseId);

    /**
     * 查询科目信息列表
     * 
     * @param basicdataCourse 科目信息
     * @return 科目信息集合
     */
    public List<BasicdataCourse> selectBasicdataCourseList(BasicdataCourse basicdataCourse);

    /**
     * 新增科目信息
     * 
     * @param basicdataCourse 科目信息
     * @return 结果
     */
    public int insertBasicdataCourse(BasicdataCourse basicdataCourse);

    /**
     * 修改科目信息
     * 
     * @param basicdataCourse 科目信息
     * @return 结果
     */
    public int updateBasicdataCourse(BasicdataCourse basicdataCourse);

    /**
     * 批量删除科目信息
     * 
     * @param courseIds 需要删除的科目信息主键集合
     * @return 结果
     */
    public int deleteBasicdataCourseByCourseIds(Long[] courseIds);

    /**
     * 删除科目信息信息
     * 
     * @param courseId 科目信息主键
     * @return 结果
     */
    public int deleteBasicdataCourseByCourseId(Long courseId);
}
