package com.renhuas.evaluation.service.impl;

import java.util.List;
import com.renhuas.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.renhuas.evaluation.mapper.EvalTeacherMapper;
import com.renhuas.evaluation.domain.EvalTeacher;
import com.renhuas.evaluation.service.IEvalTeacherService;

/**
 * 老师教学测评Service业务层处理
 * 
 * @author chenzr
 * @date 2021-11-04
 */
@Service
public class EvalTeacherServiceImpl implements IEvalTeacherService 
{
    @Autowired
    private EvalTeacherMapper evalTeacherMapper;

    /**
     * 查询老师教学测评
     * 
     * @param evalId 老师教学测评主键
     * @return 老师教学测评
     */
    @Override
    public EvalTeacher selectEvalTeacherByEvalId(Long evalId)
    {
        return evalTeacherMapper.selectEvalTeacherByEvalId(evalId);
    }

    /**
     * 查询老师教学测评列表
     * 
     * @param evalTeacher 老师教学测评
     * @return 老师教学测评
     */
    @Override
    public List<EvalTeacher> selectEvalTeacherList(EvalTeacher evalTeacher)
    {
        return evalTeacherMapper.selectEvalTeacherList(evalTeacher);
    }

    /**
     * 新增老师教学测评
     * 
     * @param evalTeacher 老师教学测评
     * @return 结果
     */
    @Override
    public int insertEvalTeacher(EvalTeacher evalTeacher)
    {
        evalTeacher.setCreateTime(DateUtils.getNowDate());
        return evalTeacherMapper.insertEvalTeacher(evalTeacher);
    }

    /**
     * 修改老师教学测评
     * 
     * @param evalTeacher 老师教学测评
     * @return 结果
     */
    @Override
    public int updateEvalTeacher(EvalTeacher evalTeacher)
    {
        return evalTeacherMapper.updateEvalTeacher(evalTeacher);
    }

    /**
     * 批量删除老师教学测评
     * 
     * @param evalIds 需要删除的老师教学测评主键
     * @return 结果
     */
    @Override
    public int deleteEvalTeacherByEvalIds(Long[] evalIds)
    {
        return evalTeacherMapper.deleteEvalTeacherByEvalIds(evalIds);
    }

    /**
     * 删除老师教学测评信息
     * 
     * @param evalId 老师教学测评主键
     * @return 结果
     */
    @Override
    public int deleteEvalTeacherByEvalId(Long evalId)
    {
        return evalTeacherMapper.deleteEvalTeacherByEvalId(evalId);
    }
}
