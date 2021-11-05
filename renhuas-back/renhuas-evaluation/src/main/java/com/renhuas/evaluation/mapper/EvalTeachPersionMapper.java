package com.renhuas.evaluation.mapper;

import java.util.List;
import com.renhuas.evaluation.domain.EvalTeachPersion;

/**
 * 老师个人测评Mapper接口
 * 
 * @author chenzr
 * @date 2021-11-04
 */
public interface EvalTeachPersionMapper 
{
    /**
     * 查询老师个人测评
     * 
     * @param evalId 老师个人测评主键
     * @return 老师个人测评
     */
    public EvalTeachPersion selectEvalTeachPersionByEvalId(Long evalId);

    /**
     * 查询老师个人测评列表
     * 
     * @param evalTeachPersion 老师个人测评
     * @return 老师个人测评集合
     */
    public List<EvalTeachPersion> selectEvalTeachPersionList(EvalTeachPersion evalTeachPersion);

    /**
     * 新增老师个人测评
     * 
     * @param evalTeachPersion 老师个人测评
     * @return 结果
     */
    public int insertEvalTeachPersion(EvalTeachPersion evalTeachPersion);

    /**
     * 修改老师个人测评
     * 
     * @param evalTeachPersion 老师个人测评
     * @return 结果
     */
    public int updateEvalTeachPersion(EvalTeachPersion evalTeachPersion);

    /**
     * 删除老师个人测评
     * 
     * @param evalId 老师个人测评主键
     * @return 结果
     */
    public int deleteEvalTeachPersionByEvalId(Long evalId);

    /**
     * 批量删除老师个人测评
     * 
     * @param evalIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEvalTeachPersionByEvalIds(Long[] evalIds);
}
