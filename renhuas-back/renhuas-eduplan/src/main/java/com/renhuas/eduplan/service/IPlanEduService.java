package com.renhuas.eduplan.service;

import java.util.List;
import com.renhuas.eduplan.domain.PlanEdu;

/**
 * 方案管理Service接口
 * 
 * @author chenzr
 * @date 2021-11-05
 */
public interface IPlanEduService 
{
    /**
     * 查询方案管理
     * 
     * @param planId 方案管理主键
     * @return 方案管理
     */
    public PlanEdu selectPlanEduByPlanId(Long planId);

    /**
     * 查询方案管理列表
     * 
     * @param planEdu 方案管理
     * @return 方案管理集合
     */
    public List<PlanEdu> selectPlanEduList(PlanEdu planEdu);

    /**
     * 新增方案管理
     * 
     * @param planEdu 方案管理
     * @return 结果
     */
    public int insertPlanEdu(PlanEdu planEdu);

    /**
     * 修改方案管理
     * 
     * @param planEdu 方案管理
     * @return 结果
     */
    public int updatePlanEdu(PlanEdu planEdu);

    /**
     * 批量删除方案管理
     * 
     * @param planIds 需要删除的方案管理主键集合
     * @return 结果
     */
    public int deletePlanEduByPlanIds(Long[] planIds);

    /**
     * 删除方案管理信息
     * 
     * @param planId 方案管理主键
     * @return 结果
     */
    public int deletePlanEduByPlanId(Long planId);
}
