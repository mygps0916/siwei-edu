package com.renhuas.evalanalyze.service.impl;

import java.util.List;
import com.renhuas.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.renhuas.evalanalyze.mapper.AnalyzeSchEvalMapper;
import com.renhuas.evalanalyze.domain.AnalyzeSchEval;
import com.renhuas.evalanalyze.service.IAnalyzeSchEvalService;

/**
 * 学校测评分析Service业务层处理
 * 
 * @author chenzr
 * @date 2021-11-04
 */
@Service
public class AnalyzeSchEvalServiceImpl implements IAnalyzeSchEvalService 
{
    @Autowired
    private AnalyzeSchEvalMapper analyzeSchEvalMapper;

    /**
     * 查询学校测评分析
     * 
     * @param analyzeId 学校测评分析主键
     * @return 学校测评分析
     */
    @Override
    public AnalyzeSchEval selectAnalyzeSchEvalByAnalyzeId(Long analyzeId)
    {
        return analyzeSchEvalMapper.selectAnalyzeSchEvalByAnalyzeId(analyzeId);
    }

    /**
     * 查询学校测评分析列表
     * 
     * @param analyzeSchEval 学校测评分析
     * @return 学校测评分析
     */
    @Override
    public List<AnalyzeSchEval> selectAnalyzeSchEvalList(AnalyzeSchEval analyzeSchEval)
    {
        return analyzeSchEvalMapper.selectAnalyzeSchEvalList(analyzeSchEval);
    }

    /**
     * 新增学校测评分析
     * 
     * @param analyzeSchEval 学校测评分析
     * @return 结果
     */
    @Override
    public int insertAnalyzeSchEval(AnalyzeSchEval analyzeSchEval)
    {
        analyzeSchEval.setCreateTime(DateUtils.getNowDate());
        return analyzeSchEvalMapper.insertAnalyzeSchEval(analyzeSchEval);
    }

    /**
     * 修改学校测评分析
     * 
     * @param analyzeSchEval 学校测评分析
     * @return 结果
     */
    @Override
    public int updateAnalyzeSchEval(AnalyzeSchEval analyzeSchEval)
    {
        return analyzeSchEvalMapper.updateAnalyzeSchEval(analyzeSchEval);
    }

    /**
     * 批量删除学校测评分析
     * 
     * @param analyzeIds 需要删除的学校测评分析主键
     * @return 结果
     */
    @Override
    public int deleteAnalyzeSchEvalByAnalyzeIds(Long[] analyzeIds)
    {
        return analyzeSchEvalMapper.deleteAnalyzeSchEvalByAnalyzeIds(analyzeIds);
    }

    /**
     * 删除学校测评分析信息
     * 
     * @param analyzeId 学校测评分析主键
     * @return 结果
     */
    @Override
    public int deleteAnalyzeSchEvalByAnalyzeId(Long analyzeId)
    {
        return analyzeSchEvalMapper.deleteAnalyzeSchEvalByAnalyzeId(analyzeId);
    }
}
