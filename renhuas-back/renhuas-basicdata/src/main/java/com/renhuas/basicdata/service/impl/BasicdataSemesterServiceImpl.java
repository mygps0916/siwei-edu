package com.renhuas.basicdata.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.renhuas.basicdata.mapper.BasicdataSemesterMapper;
import com.renhuas.basicdata.domain.BasicdataSemester;
import com.renhuas.basicdata.service.IBasicdataSemesterService;

/**
 * 学期信息Service业务层处理
 * 
 * @author chenzr
 * @date 2021-11-04
 */
@Service
public class BasicdataSemesterServiceImpl implements IBasicdataSemesterService 
{
    @Autowired
    private BasicdataSemesterMapper basicdataSemesterMapper;

    /**
     * 查询学期信息
     * 
     * @param semesterId 学期信息主键
     * @return 学期信息
     */
    @Override
    public BasicdataSemester selectBasicdataSemesterBySemesterId(Long semesterId)
    {
        return basicdataSemesterMapper.selectBasicdataSemesterBySemesterId(semesterId);
    }

    /**
     * 查询学期信息列表
     * 
     * @param basicdataSemester 学期信息
     * @return 学期信息
     */
    @Override
    public List<BasicdataSemester> selectBasicdataSemesterList(BasicdataSemester basicdataSemester)
    {
        return basicdataSemesterMapper.selectBasicdataSemesterList(basicdataSemester);
    }

    /**
     * 新增学期信息
     * 
     * @param basicdataSemester 学期信息
     * @return 结果
     */
    @Override
    public int insertBasicdataSemester(BasicdataSemester basicdataSemester)
    {
        return basicdataSemesterMapper.insertBasicdataSemester(basicdataSemester);
    }

    /**
     * 修改学期信息
     * 
     * @param basicdataSemester 学期信息
     * @return 结果
     */
    @Override
    public int updateBasicdataSemester(BasicdataSemester basicdataSemester)
    {
        return basicdataSemesterMapper.updateBasicdataSemester(basicdataSemester);
    }

    /**
     * 批量删除学期信息
     * 
     * @param semesterIds 需要删除的学期信息主键
     * @return 结果
     */
    @Override
    public int deleteBasicdataSemesterBySemesterIds(Long[] semesterIds)
    {
        return basicdataSemesterMapper.deleteBasicdataSemesterBySemesterIds(semesterIds);
    }

    /**
     * 删除学期信息信息
     * 
     * @param semesterId 学期信息主键
     * @return 结果
     */
    @Override
    public int deleteBasicdataSemesterBySemesterId(Long semesterId)
    {
        return basicdataSemesterMapper.deleteBasicdataSemesterBySemesterId(semesterId);
    }
}
