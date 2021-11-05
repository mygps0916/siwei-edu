package com.renhuas.evaluation.service.impl;

import java.util.List;
import com.renhuas.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.renhuas.evaluation.mapper.EvalEduQualityMapper;
import com.renhuas.evaluation.domain.EvalEduQuality;
import com.renhuas.evaluation.service.IEvalEduQualityService;

/**
 * 教学质量评测Service业务层处理
 * 
 * @author chenzr
 * @date 2021-11-04
 */
@Service
public class EvalEduQualityServiceImpl implements IEvalEduQualityService 
{
    @Autowired
    private EvalEduQualityMapper evalEduQualityMapper;

    /**
     * 查询教学质量评测
     * 
     * @param techQualityId 教学质量评测主键
     * @return 教学质量评测
     */
    @Override
    public EvalEduQuality selectEvalEduQualityByTechQualityId(Long techQualityId)
    {
        return evalEduQualityMapper.selectEvalEduQualityByTechQualityId(techQualityId);
    }

    /**
     * 查询教学质量评测列表
     * 
     * @param evalEduQuality 教学质量评测
     * @return 教学质量评测
     */
    @Override
    public List<EvalEduQuality> selectEvalEduQualityList(EvalEduQuality evalEduQuality)
    {
        return evalEduQualityMapper.selectEvalEduQualityList(evalEduQuality);
    }

    /**
     * 新增教学质量评测
     * 
     * @param evalEduQuality 教学质量评测
     * @return 结果
     */
    @Override
    public int insertEvalEduQuality(EvalEduQuality evalEduQuality)
    {
        evalEduQuality.setCreateTime(DateUtils.getNowDate());
        return evalEduQualityMapper.insertEvalEduQuality(evalEduQuality);
    }

    /**
     * 修改教学质量评测
     * 
     * @param evalEduQuality 教学质量评测
     * @return 结果
     */
    @Override
    public int updateEvalEduQuality(EvalEduQuality evalEduQuality)
    {
        return evalEduQualityMapper.updateEvalEduQuality(evalEduQuality);
    }

    /**
     * 批量删除教学质量评测
     * 
     * @param techQualityIds 需要删除的教学质量评测主键
     * @return 结果
     */
    @Override
    public int deleteEvalEduQualityByTechQualityIds(Long[] techQualityIds)
    {
        return evalEduQualityMapper.deleteEvalEduQualityByTechQualityIds(techQualityIds);
    }

    /**
     * 删除教学质量评测信息
     * 
     * @param techQualityId 教学质量评测主键
     * @return 结果
     */
    @Override
    public int deleteEvalEduQualityByTechQualityId(Long techQualityId)
    {
        return evalEduQualityMapper.deleteEvalEduQualityByTechQualityId(techQualityId);
    }
}
