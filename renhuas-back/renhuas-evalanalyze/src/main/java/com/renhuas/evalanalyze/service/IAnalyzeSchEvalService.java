package com.renhuas.evalanalyze.service;

import java.util.List;
import com.renhuas.evalanalyze.domain.AnalyzeSchEval;

/**
 * 学校测评分析Service接口
 * 
 * @author chenzr
 * @date 2021-11-04
 */
public interface IAnalyzeSchEvalService 
{
    /**
     * 查询学校测评分析
     * 
     * @param analyzeId 学校测评分析主键
     * @return 学校测评分析
     */
    public AnalyzeSchEval selectAnalyzeSchEvalByAnalyzeId(Long analyzeId);

    /**
     * 查询学校测评分析列表
     * 
     * @param analyzeSchEval 学校测评分析
     * @return 学校测评分析集合
     */
    public List<AnalyzeSchEval> selectAnalyzeSchEvalList(AnalyzeSchEval analyzeSchEval);

    /**
     * 新增学校测评分析
     * 
     * @param analyzeSchEval 学校测评分析
     * @return 结果
     */
    public int insertAnalyzeSchEval(AnalyzeSchEval analyzeSchEval);

    /**
     * 修改学校测评分析
     * 
     * @param analyzeSchEval 学校测评分析
     * @return 结果
     */
    public int updateAnalyzeSchEval(AnalyzeSchEval analyzeSchEval);

    /**
     * 批量删除学校测评分析
     * 
     * @param analyzeIds 需要删除的学校测评分析主键集合
     * @return 结果
     */
    public int deleteAnalyzeSchEvalByAnalyzeIds(Long[] analyzeIds);

    /**
     * 删除学校测评分析信息
     * 
     * @param analyzeId 学校测评分析主键
     * @return 结果
     */
    public int deleteAnalyzeSchEvalByAnalyzeId(Long analyzeId);
}
