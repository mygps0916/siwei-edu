package com.renhuas.evaluation.mapper;

import java.util.List;
import com.renhuas.evaluation.domain.EvalEduQuality;

/**
 * 教学质量评测Mapper接口
 * 
 * @author chenzr
 * @date 2021-11-04
 */
public interface EvalEduQualityMapper 
{
    /**
     * 查询教学质量评测
     * 
     * @param techQualityId 教学质量评测主键
     * @return 教学质量评测
     */
    public EvalEduQuality selectEvalEduQualityByTechQualityId(Long techQualityId);

    /**
     * 查询教学质量评测列表
     * 
     * @param evalEduQuality 教学质量评测
     * @return 教学质量评测集合
     */
    public List<EvalEduQuality> selectEvalEduQualityList(EvalEduQuality evalEduQuality);

    /**
     * 新增教学质量评测
     * 
     * @param evalEduQuality 教学质量评测
     * @return 结果
     */
    public int insertEvalEduQuality(EvalEduQuality evalEduQuality);

    /**
     * 修改教学质量评测
     * 
     * @param evalEduQuality 教学质量评测
     * @return 结果
     */
    public int updateEvalEduQuality(EvalEduQuality evalEduQuality);

    /**
     * 删除教学质量评测
     * 
     * @param techQualityId 教学质量评测主键
     * @return 结果
     */
    public int deleteEvalEduQualityByTechQualityId(Long techQualityId);

    /**
     * 批量删除教学质量评测
     * 
     * @param techQualityIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEvalEduQualityByTechQualityIds(Long[] techQualityIds);
}
