package com.renhuas.eduplan.service.impl;

import java.util.List;
import com.renhuas.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.renhuas.eduplan.mapper.PlanEduMapper;
import com.renhuas.eduplan.domain.PlanEdu;
import com.renhuas.eduplan.service.IPlanEduService;

/**
 * 方案管理Service业务层处理
 * 
 * @author chenzr
 * @date 2021-11-05
 */
@Service
public class PlanEduServiceImpl implements IPlanEduService 
{
    @Autowired
    private PlanEduMapper planEduMapper;

    /**
     * 查询方案管理
     * 
     * @param planId 方案管理主键
     * @return 方案管理
     */
    @Override
    public PlanEdu selectPlanEduByPlanId(Long planId)
    {
        return planEduMapper.selectPlanEduByPlanId(planId);
    }

    /**
     * 查询方案管理列表
     * 
     * @param planEdu 方案管理
     * @return 方案管理
     */
    @Override
    public List<PlanEdu> selectPlanEduList(PlanEdu planEdu)
    {
        return planEduMapper.selectPlanEduList(planEdu);
    }

    /**
     * 新增方案管理
     * 
     * @param planEdu 方案管理
     * @return 结果
     */
    @Override
    public int insertPlanEdu(PlanEdu planEdu)
    {
        planEdu.setCreateTime(DateUtils.getNowDate());
        return planEduMapper.insertPlanEdu(planEdu);
    }

    /**
     * 修改方案管理
     * 
     * @param planEdu 方案管理
     * @return 结果
     */
    @Override
    public int updatePlanEdu(PlanEdu planEdu)
    {
        return planEduMapper.updatePlanEdu(planEdu);
    }

    /**
     * 批量删除方案管理
     * 
     * @param planIds 需要删除的方案管理主键
     * @return 结果
     */
    @Override
    public int deletePlanEduByPlanIds(Long[] planIds)
    {
        return planEduMapper.deletePlanEduByPlanIds(planIds);
    }

    /**
     * 删除方案管理信息
     * 
     * @param planId 方案管理主键
     * @return 结果
     */
    @Override
    public int deletePlanEduByPlanId(Long planId)
    {
        return planEduMapper.deletePlanEduByPlanId(planId);
    }
}
