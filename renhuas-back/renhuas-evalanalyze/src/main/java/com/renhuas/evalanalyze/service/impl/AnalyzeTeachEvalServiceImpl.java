package com.renhuas.evalanalyze.service.impl;

import java.util.List;
import com.renhuas.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.renhuas.evalanalyze.mapper.AnalyzeTeachEvalMapper;
import com.renhuas.evalanalyze.domain.AnalyzeTeachEval;
import com.renhuas.evalanalyze.service.IAnalyzeTeachEvalService;

/**
 * 老师测评分析Service业务层处理
 * 
 * @author chenzr
 * @date 2021-11-04
 */
@Service
public class AnalyzeTeachEvalServiceImpl implements IAnalyzeTeachEvalService 
{
    @Autowired
    private AnalyzeTeachEvalMapper analyzeTeachEvalMapper;

    /**
     * 查询老师测评分析
     * 
     * @param analyzeId 老师测评分析主键
     * @return 老师测评分析
     */
    @Override
    public AnalyzeTeachEval selectAnalyzeTeachEvalByAnalyzeId(Long analyzeId)
    {
        return analyzeTeachEvalMapper.selectAnalyzeTeachEvalByAnalyzeId(analyzeId);
    }

    /**
     * 查询老师测评分析列表
     * 
     * @param analyzeTeachEval 老师测评分析
     * @return 老师测评分析
     */
    @Override
    public List<AnalyzeTeachEval> selectAnalyzeTeachEvalList(AnalyzeTeachEval analyzeTeachEval)
    {
        return analyzeTeachEvalMapper.selectAnalyzeTeachEvalList(analyzeTeachEval);
    }

    /**
     * 新增老师测评分析
     * 
     * @param analyzeTeachEval 老师测评分析
     * @return 结果
     */
    @Override
    public int insertAnalyzeTeachEval(AnalyzeTeachEval analyzeTeachEval)
    {
        analyzeTeachEval.setCreateTime(DateUtils.getNowDate());
        return analyzeTeachEvalMapper.insertAnalyzeTeachEval(analyzeTeachEval);
    }

    /**
     * 修改老师测评分析
     * 
     * @param analyzeTeachEval 老师测评分析
     * @return 结果
     */
    @Override
    public int updateAnalyzeTeachEval(AnalyzeTeachEval analyzeTeachEval)
    {
        return analyzeTeachEvalMapper.updateAnalyzeTeachEval(analyzeTeachEval);
    }

    /**
     * 批量删除老师测评分析
     * 
     * @param analyzeIds 需要删除的老师测评分析主键
     * @return 结果
     */
    @Override
    public int deleteAnalyzeTeachEvalByAnalyzeIds(Long[] analyzeIds)
    {
        return analyzeTeachEvalMapper.deleteAnalyzeTeachEvalByAnalyzeIds(analyzeIds);
    }

    /**
     * 删除老师测评分析信息
     * 
     * @param analyzeId 老师测评分析主键
     * @return 结果
     */
    @Override
    public int deleteAnalyzeTeachEvalByAnalyzeId(Long analyzeId)
    {
        return analyzeTeachEvalMapper.deleteAnalyzeTeachEvalByAnalyzeId(analyzeId);
    }
}
