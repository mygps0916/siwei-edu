package com.renhuas.edutrace.service.impl;

import java.util.List;
import com.renhuas.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.renhuas.edutrace.mapper.TraceEduTeachMapper;
import com.renhuas.edutrace.domain.TraceEduTeach;
import com.renhuas.edutrace.service.ITraceEduTeachService;

/**
 * 老师教学追溯Service业务层处理
 * 
 * @author chenzr
 * @date 2021-11-04
 */
@Service
public class TraceEduTeachServiceImpl implements ITraceEduTeachService 
{
    @Autowired
    private TraceEduTeachMapper traceEduTeachMapper;

    /**
     * 查询老师教学追溯
     * 
     * @param traceId 老师教学追溯主键
     * @return 老师教学追溯
     */
    @Override
    public TraceEduTeach selectTraceEduTeachByTraceId(Long traceId)
    {
        return traceEduTeachMapper.selectTraceEduTeachByTraceId(traceId);
    }

    /**
     * 查询老师教学追溯列表
     * 
     * @param traceEduTeach 老师教学追溯
     * @return 老师教学追溯
     */
    @Override
    public List<TraceEduTeach> selectTraceEduTeachList(TraceEduTeach traceEduTeach)
    {
        return traceEduTeachMapper.selectTraceEduTeachList(traceEduTeach);
    }

    /**
     * 新增老师教学追溯
     * 
     * @param traceEduTeach 老师教学追溯
     * @return 结果
     */
    @Override
    public int insertTraceEduTeach(TraceEduTeach traceEduTeach)
    {
        traceEduTeach.setCreateTime(DateUtils.getNowDate());
        return traceEduTeachMapper.insertTraceEduTeach(traceEduTeach);
    }

    /**
     * 修改老师教学追溯
     * 
     * @param traceEduTeach 老师教学追溯
     * @return 结果
     */
    @Override
    public int updateTraceEduTeach(TraceEduTeach traceEduTeach)
    {
        return traceEduTeachMapper.updateTraceEduTeach(traceEduTeach);
    }

    /**
     * 批量删除老师教学追溯
     * 
     * @param traceIds 需要删除的老师教学追溯主键
     * @return 结果
     */
    @Override
    public int deleteTraceEduTeachByTraceIds(Long[] traceIds)
    {
        return traceEduTeachMapper.deleteTraceEduTeachByTraceIds(traceIds);
    }

    /**
     * 删除老师教学追溯信息
     * 
     * @param traceId 老师教学追溯主键
     * @return 结果
     */
    @Override
    public int deleteTraceEduTeachByTraceId(Long traceId)
    {
        return traceEduTeachMapper.deleteTraceEduTeachByTraceId(traceId);
    }
}
