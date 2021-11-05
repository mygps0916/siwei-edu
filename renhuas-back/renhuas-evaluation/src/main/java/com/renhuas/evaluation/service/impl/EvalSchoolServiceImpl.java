package com.renhuas.evaluation.service.impl;

import java.util.List;
import com.renhuas.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.renhuas.evaluation.mapper.EvalSchoolMapper;
import com.renhuas.evaluation.domain.EvalSchool;
import com.renhuas.evaluation.service.IEvalSchoolService;

/**
 * 学校测评Service业务层处理
 * 
 * @author chenzr
 * @date 2021-11-04
 */
@Service
public class EvalSchoolServiceImpl implements IEvalSchoolService 
{
    @Autowired
    private EvalSchoolMapper evalSchoolMapper;

    /**
     * 查询学校测评
     * 
     * @param evalId 学校测评主键
     * @return 学校测评
     */
    @Override
    public EvalSchool selectEvalSchoolByEvalId(Long evalId)
    {
        return evalSchoolMapper.selectEvalSchoolByEvalId(evalId);
    }

    /**
     * 查询学校测评列表
     * 
     * @param evalSchool 学校测评
     * @return 学校测评
     */
    @Override
    public List<EvalSchool> selectEvalSchoolList(EvalSchool evalSchool)
    {
        return evalSchoolMapper.selectEvalSchoolList(evalSchool);
    }

    /**
     * 新增学校测评
     * 
     * @param evalSchool 学校测评
     * @return 结果
     */
    @Override
    public int insertEvalSchool(EvalSchool evalSchool)
    {
        evalSchool.setCreateTime(DateUtils.getNowDate());
        return evalSchoolMapper.insertEvalSchool(evalSchool);
    }

    /**
     * 修改学校测评
     * 
     * @param evalSchool 学校测评
     * @return 结果
     */
    @Override
    public int updateEvalSchool(EvalSchool evalSchool)
    {
        return evalSchoolMapper.updateEvalSchool(evalSchool);
    }

    /**
     * 批量删除学校测评
     * 
     * @param evalIds 需要删除的学校测评主键
     * @return 结果
     */
    @Override
    public int deleteEvalSchoolByEvalIds(Long[] evalIds)
    {
        return evalSchoolMapper.deleteEvalSchoolByEvalIds(evalIds);
    }

    /**
     * 删除学校测评信息
     * 
     * @param evalId 学校测评主键
     * @return 结果
     */
    @Override
    public int deleteEvalSchoolByEvalId(Long evalId)
    {
        return evalSchoolMapper.deleteEvalSchoolByEvalId(evalId);
    }
}
