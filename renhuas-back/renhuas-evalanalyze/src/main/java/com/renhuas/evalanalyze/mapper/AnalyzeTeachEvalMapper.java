package com.renhuas.evalanalyze.mapper;

import java.util.List;
import com.renhuas.evalanalyze.domain.AnalyzeTeachEval;

/**
 * 老师测评分析Mapper接口
 * 
 * @author chenzr
 * @date 2021-11-04
 */
public interface AnalyzeTeachEvalMapper 
{
    /**
     * 查询老师测评分析
     * 
     * @param analyzeId 老师测评分析主键
     * @return 老师测评分析
     */
    public AnalyzeTeachEval selectAnalyzeTeachEvalByAnalyzeId(Long analyzeId);

    /**
     * 查询老师测评分析列表
     * 
     * @param analyzeTeachEval 老师测评分析
     * @return 老师测评分析集合
     */
    public List<AnalyzeTeachEval> selectAnalyzeTeachEvalList(AnalyzeTeachEval analyzeTeachEval);

    /**
     * 新增老师测评分析
     * 
     * @param analyzeTeachEval 老师测评分析
     * @return 结果
     */
    public int insertAnalyzeTeachEval(AnalyzeTeachEval analyzeTeachEval);

    /**
     * 修改老师测评分析
     * 
     * @param analyzeTeachEval 老师测评分析
     * @return 结果
     */
    public int updateAnalyzeTeachEval(AnalyzeTeachEval analyzeTeachEval);

    /**
     * 删除老师测评分析
     * 
     * @param analyzeId 老师测评分析主键
     * @return 结果
     */
    public int deleteAnalyzeTeachEvalByAnalyzeId(Long analyzeId);

    /**
     * 批量删除老师测评分析
     * 
     * @param analyzeIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAnalyzeTeachEvalByAnalyzeIds(Long[] analyzeIds);
}
