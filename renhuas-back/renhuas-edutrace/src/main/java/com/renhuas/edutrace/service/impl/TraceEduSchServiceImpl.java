package com.renhuas.edutrace.service.impl;

import java.util.List;
import com.renhuas.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.renhuas.edutrace.mapper.TraceEduSchMapper;
import com.renhuas.edutrace.domain.TraceEduSch;
import com.renhuas.edutrace.service.ITraceEduSchService;

/**
 * 学校教学追溯Service业务层处理
 * 
 * @author chenzr
 * @date 2021-11-04
 */
@Service
public class TraceEduSchServiceImpl implements ITraceEduSchService 
{
    @Autowired
    private TraceEduSchMapper traceEduSchMapper;

    /**
     * 查询学校教学追溯
     * 
     * @param traceId 学校教学追溯主键
     * @return 学校教学追溯
     */
    @Override
    public TraceEduSch selectTraceEduSchByTraceId(Long traceId)
    {
        return traceEduSchMapper.selectTraceEduSchByTraceId(traceId);
    }

    /**
     * 查询学校教学追溯列表
     * 
     * @param traceEduSch 学校教学追溯
     * @return 学校教学追溯
     */
    @Override
    public List<TraceEduSch> selectTraceEduSchList(TraceEduSch traceEduSch)
    {
        return traceEduSchMapper.selectTraceEduSchList(traceEduSch);
    }

    /**
     * 新增学校教学追溯
     * 
     * @param traceEduSch 学校教学追溯
     * @return 结果
     */
    @Override
    public int insertTraceEduSch(TraceEduSch traceEduSch)
    {
        traceEduSch.setCreateTime(DateUtils.getNowDate());
        return traceEduSchMapper.insertTraceEduSch(traceEduSch);
    }

    /**
     * 修改学校教学追溯
     * 
     * @param traceEduSch 学校教学追溯
     * @return 结果
     */
    @Override
    public int updateTraceEduSch(TraceEduSch traceEduSch)
    {
        return traceEduSchMapper.updateTraceEduSch(traceEduSch);
    }

    /**
     * 批量删除学校教学追溯
     * 
     * @param traceIds 需要删除的学校教学追溯主键
     * @return 结果
     */
    @Override
    public int deleteTraceEduSchByTraceIds(Long[] traceIds)
    {
        return traceEduSchMapper.deleteTraceEduSchByTraceIds(traceIds);
    }

    /**
     * 删除学校教学追溯信息
     * 
     * @param traceId 学校教学追溯主键
     * @return 结果
     */
    @Override
    public int deleteTraceEduSchByTraceId(Long traceId)
    {
        return traceEduSchMapper.deleteTraceEduSchByTraceId(traceId);
    }
}
