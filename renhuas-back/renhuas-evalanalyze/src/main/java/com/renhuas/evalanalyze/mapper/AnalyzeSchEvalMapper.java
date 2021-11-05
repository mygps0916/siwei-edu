package com.renhuas.evalanalyze.mapper;

import java.util.List;
import com.renhuas.evalanalyze.domain.AnalyzeSchEval;

/**
 * 学校测评分析Mapper接口
 * 
 * @author chenzr
 * @date 2021-11-04
 */
public interface AnalyzeSchEvalMapper 
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
     * 删除学校测评分析
     * 
     * @param analyzeId 学校测评分析主键
     * @return 结果
     */
    public int deleteAnalyzeSchEvalByAnalyzeId(Long analyzeId);

    /**
     * 批量删除学校测评分析
     * 
     * @param analyzeIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAnalyzeSchEvalByAnalyzeIds(Long[] analyzeIds);
}
