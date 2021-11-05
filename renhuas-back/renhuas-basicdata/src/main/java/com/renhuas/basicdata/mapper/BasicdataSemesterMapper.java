package com.renhuas.basicdata.mapper;

import java.util.List;
import com.renhuas.basicdata.domain.BasicdataSemester;

/**
 * 学期信息Mapper接口
 * 
 * @author chenzr
 * @date 2021-11-04
 */
public interface BasicdataSemesterMapper 
{
    /**
     * 查询学期信息
     * 
     * @param semesterId 学期信息主键
     * @return 学期信息
     */
    public BasicdataSemester selectBasicdataSemesterBySemesterId(Long semesterId);

    /**
     * 查询学期信息列表
     * 
     * @param basicdataSemester 学期信息
     * @return 学期信息集合
     */
    public List<BasicdataSemester> selectBasicdataSemesterList(BasicdataSemester basicdataSemester);

    /**
     * 新增学期信息
     * 
     * @param basicdataSemester 学期信息
     * @return 结果
     */
    public int insertBasicdataSemester(BasicdataSemester basicdataSemester);

    /**
     * 修改学期信息
     * 
     * @param basicdataSemester 学期信息
     * @return 结果
     */
    public int updateBasicdataSemester(BasicdataSemester basicdataSemester);

    /**
     * 删除学期信息
     * 
     * @param semesterId 学期信息主键
     * @return 结果
     */
    public int deleteBasicdataSemesterBySemesterId(Long semesterId);

    /**
     * 批量删除学期信息
     * 
     * @param semesterIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBasicdataSemesterBySemesterIds(Long[] semesterIds);
}
