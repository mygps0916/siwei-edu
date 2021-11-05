package com.renhuas.edutrace.mapper;

import java.util.List;
import com.renhuas.edutrace.domain.TraceEduStudent;

/**
 * 学生教学质量追溯Mapper接口
 * 
 * @author chenzr
 * @date 2021-11-04
 */
public interface TraceEduStudentMapper 
{
    /**
     * 查询学生教学质量追溯
     * 
     * @param traceId 学生教学质量追溯主键
     * @return 学生教学质量追溯
     */
    public TraceEduStudent selectTraceEduStudentByTraceId(Long traceId);

    /**
     * 查询学生教学质量追溯列表
     * 
     * @param traceEduStudent 学生教学质量追溯
     * @return 学生教学质量追溯集合
     */
    public List<TraceEduStudent> selectTraceEduStudentList(TraceEduStudent traceEduStudent);

    /**
     * 新增学生教学质量追溯
     * 
     * @param traceEduStudent 学生教学质量追溯
     * @return 结果
     */
    public int insertTraceEduStudent(TraceEduStudent traceEduStudent);

    /**
     * 修改学生教学质量追溯
     * 
     * @param traceEduStudent 学生教学质量追溯
     * @return 结果
     */
    public int updateTraceEduStudent(TraceEduStudent traceEduStudent);

    /**
     * 删除学生教学质量追溯
     * 
     * @param traceId 学生教学质量追溯主键
     * @return 结果
     */
    public int deleteTraceEduStudentByTraceId(Long traceId);

    /**
     * 批量删除学生教学质量追溯
     * 
     * @param traceIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTraceEduStudentByTraceIds(Long[] traceIds);
}
