package com.renhuas.edutrace.mapper;

import java.util.List;
import com.renhuas.edutrace.domain.TraceEduTeach;

/**
 * 老师教学追溯Mapper接口
 * 
 * @author chenzr
 * @date 2021-11-04
 */
public interface TraceEduTeachMapper 
{
    /**
     * 查询老师教学追溯
     * 
     * @param traceId 老师教学追溯主键
     * @return 老师教学追溯
     */
    public TraceEduTeach selectTraceEduTeachByTraceId(Long traceId);

    /**
     * 查询老师教学追溯列表
     * 
     * @param traceEduTeach 老师教学追溯
     * @return 老师教学追溯集合
     */
    public List<TraceEduTeach> selectTraceEduTeachList(TraceEduTeach traceEduTeach);

    /**
     * 新增老师教学追溯
     * 
     * @param traceEduTeach 老师教学追溯
     * @return 结果
     */
    public int insertTraceEduTeach(TraceEduTeach traceEduTeach);

    /**
     * 修改老师教学追溯
     * 
     * @param traceEduTeach 老师教学追溯
     * @return 结果
     */
    public int updateTraceEduTeach(TraceEduTeach traceEduTeach);

    /**
     * 删除老师教学追溯
     * 
     * @param traceId 老师教学追溯主键
     * @return 结果
     */
    public int deleteTraceEduTeachByTraceId(Long traceId);

    /**
     * 批量删除老师教学追溯
     * 
     * @param traceIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTraceEduTeachByTraceIds(Long[] traceIds);
}
