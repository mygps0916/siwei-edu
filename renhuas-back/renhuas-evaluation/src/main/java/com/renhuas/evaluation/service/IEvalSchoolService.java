package com.renhuas.evaluation.service;

import java.util.List;
import com.renhuas.evaluation.domain.EvalSchool;

/**
 * 学校测评Service接口
 * 
 * @author chenzr
 * @date 2021-11-04
 */
public interface IEvalSchoolService 
{
    /**
     * 查询学校测评
     * 
     * @param evalId 学校测评主键
     * @return 学校测评
     */
    public EvalSchool selectEvalSchoolByEvalId(Long evalId);

    /**
     * 查询学校测评列表
     * 
     * @param evalSchool 学校测评
     * @return 学校测评集合
     */
    public List<EvalSchool> selectEvalSchoolList(EvalSchool evalSchool);

    /**
     * 新增学校测评
     * 
     * @param evalSchool 学校测评
     * @return 结果
     */
    public int insertEvalSchool(EvalSchool evalSchool);

    /**
     * 修改学校测评
     * 
     * @param evalSchool 学校测评
     * @return 结果
     */
    public int updateEvalSchool(EvalSchool evalSchool);

    /**
     * 批量删除学校测评
     * 
     * @param evalIds 需要删除的学校测评主键集合
     * @return 结果
     */
    public int deleteEvalSchoolByEvalIds(Long[] evalIds);

    /**
     * 删除学校测评信息
     * 
     * @param evalId 学校测评主键
     * @return 结果
     */
    public int deleteEvalSchoolByEvalId(Long evalId);
}
