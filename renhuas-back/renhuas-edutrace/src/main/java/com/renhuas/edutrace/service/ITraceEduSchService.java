package com.renhuas.edutrace.service;

import java.util.List;
import com.renhuas.edutrace.domain.TraceEduSch;

/**
 * 学校教学追溯Service接口
 * 
 * @author chenzr
 * @date 2021-11-04
 */
public interface ITraceEduSchService 
{
    /**
     * 查询学校教学追溯
     * 
     * @param traceId 学校教学追溯主键
     * @return 学校教学追溯
     */
    public TraceEduSch selectTraceEduSchByTraceId(Long traceId);

    /**
     * 查询学校教学追溯列表
     * 
     * @param traceEduSch 学校教学追溯
     * @return 学校教学追溯集合
     */
    public List<TraceEduSch> selectTraceEduSchList(TraceEduSch traceEduSch);

    /**
     * 新增学校教学追溯
     * 
     * @param traceEduSch 学校教学追溯
     * @return 结果
     */
    public int insertTraceEduSch(TraceEduSch traceEduSch);

    /**
     * 修改学校教学追溯
     * 
     * @param traceEduSch 学校教学追溯
     * @return 结果
     */
    public int updateTraceEduSch(TraceEduSch traceEduSch);

    /**
     * 批量删除学校教学追溯
     * 
     * @param traceIds 需要删除的学校教学追溯主键集合
     * @return 结果
     */
    public int deleteTraceEduSchByTraceIds(Long[] traceIds);

    /**
     * 删除学校教学追溯信息
     * 
     * @param traceId 学校教学追溯主键
     * @return 结果
     */
    public int deleteTraceEduSchByTraceId(Long traceId);
}
