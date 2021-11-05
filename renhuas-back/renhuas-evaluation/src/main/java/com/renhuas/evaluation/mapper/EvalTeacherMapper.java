package com.renhuas.evaluation.mapper;

import java.util.List;
import com.renhuas.evaluation.domain.EvalTeacher;

/**
 * 老师教学测评Mapper接口
 * 
 * @author chenzr
 * @date 2021-11-04
 */
public interface EvalTeacherMapper 
{
    /**
     * 查询老师教学测评
     * 
     * @param evalId 老师教学测评主键
     * @return 老师教学测评
     */
    public EvalTeacher selectEvalTeacherByEvalId(Long evalId);

    /**
     * 查询老师教学测评列表
     * 
     * @param evalTeacher 老师教学测评
     * @return 老师教学测评集合
     */
    public List<EvalTeacher> selectEvalTeacherList(EvalTeacher evalTeacher);

    /**
     * 新增老师教学测评
     * 
     * @param evalTeacher 老师教学测评
     * @return 结果
     */
    public int insertEvalTeacher(EvalTeacher evalTeacher);

    /**
     * 修改老师教学测评
     * 
     * @param evalTeacher 老师教学测评
     * @return 结果
     */
    public int updateEvalTeacher(EvalTeacher evalTeacher);

    /**
     * 删除老师教学测评
     * 
     * @param evalId 老师教学测评主键
     * @return 结果
     */
    public int deleteEvalTeacherByEvalId(Long evalId);

    /**
     * 批量删除老师教学测评
     * 
     * @param evalIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEvalTeacherByEvalIds(Long[] evalIds);
}
