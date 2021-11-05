package com.renhuas.edutrace.service.impl;

import java.util.List;
import com.renhuas.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.renhuas.edutrace.mapper.TraceEduStudentMapper;
import com.renhuas.edutrace.domain.TraceEduStudent;
import com.renhuas.edutrace.service.ITraceEduStudentService;

/**
 * 学生教学质量追溯Service业务层处理
 * 
 * @author chenzr
 * @date 2021-11-04
 */
@Service
public class TraceEduStudentServiceImpl implements ITraceEduStudentService 
{
    @Autowired
    private TraceEduStudentMapper traceEduStudentMapper;

    /**
     * 查询学生教学质量追溯
     * 
     * @param traceId 学生教学质量追溯主键
     * @return 学生教学质量追溯
     */
    @Override
    public TraceEduStudent selectTraceEduStudentByTraceId(Long traceId)
    {
        return traceEduStudentMapper.selectTraceEduStudentByTraceId(traceId);
    }

    /**
     * 查询学生教学质量追溯列表
     * 
     * @param traceEduStudent 学生教学质量追溯
     * @return 学生教学质量追溯
     */
    @Override
    public List<TraceEduStudent> selectTraceEduStudentList(TraceEduStudent traceEduStudent)
    {
        return traceEduStudentMapper.selectTraceEduStudentList(traceEduStudent);
    }

    /**
     * 新增学生教学质量追溯
     * 
     * @param traceEduStudent 学生教学质量追溯
     * @return 结果
     */
    @Override
    public int insertTraceEduStudent(TraceEduStudent traceEduStudent)
    {
        traceEduStudent.setCreateTime(DateUtils.getNowDate());
        return traceEduStudentMapper.insertTraceEduStudent(traceEduStudent);
    }

    /**
     * 修改学生教学质量追溯
     * 
     * @param traceEduStudent 学生教学质量追溯
     * @return 结果
     */
    @Override
    public int updateTraceEduStudent(TraceEduStudent traceEduStudent)
    {
        return traceEduStudentMapper.updateTraceEduStudent(traceEduStudent);
    }

    /**
     * 批量删除学生教学质量追溯
     * 
     * @param traceIds 需要删除的学生教学质量追溯主键
     * @return 结果
     */
    @Override
    public int deleteTraceEduStudentByTraceIds(Long[] traceIds)
    {
        return traceEduStudentMapper.deleteTraceEduStudentByTraceIds(traceIds);
    }

    /**
     * 删除学生教学质量追溯信息
     * 
     * @param traceId 学生教学质量追溯主键
     * @return 结果
     */
    @Override
    public int deleteTraceEduStudentByTraceId(Long traceId)
    {
        return traceEduStudentMapper.deleteTraceEduStudentByTraceId(traceId);
    }
}
