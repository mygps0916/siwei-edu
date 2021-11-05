package com.renhuas.evaluation.service.impl;

import java.util.List;
import com.renhuas.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.renhuas.evaluation.mapper.EvalTeachPersionMapper;
import com.renhuas.evaluation.domain.EvalTeachPersion;
import com.renhuas.evaluation.service.IEvalTeachPersionService;

/**
 * 老师个人测评Service业务层处理
 * 
 * @author chenzr
 * @date 2021-11-04
 */
@Service
public class EvalTeachPersionServiceImpl implements IEvalTeachPersionService 
{
    @Autowired
    private EvalTeachPersionMapper evalTeachPersionMapper;

    /**
     * 查询老师个人测评
     * 
     * @param evalId 老师个人测评主键
     * @return 老师个人测评
     */
    @Override
    public EvalTeachPersion selectEvalTeachPersionByEvalId(Long evalId)
    {
        return evalTeachPersionMapper.selectEvalTeachPersionByEvalId(evalId);
    }

    /**
     * 查询老师个人测评列表
     * 
     * @param evalTeachPersion 老师个人测评
     * @return 老师个人测评
     */
    @Override
    public List<EvalTeachPersion> selectEvalTeachPersionList(EvalTeachPersion evalTeachPersion)
    {
        return evalTeachPersionMapper.selectEvalTeachPersionList(evalTeachPersion);
    }

    /**
     * 新增老师个人测评
     * 
     * @param evalTeachPersion 老师个人测评
     * @return 结果
     */
    @Override
    public int insertEvalTeachPersion(EvalTeachPersion evalTeachPersion)
    {
        evalTeachPersion.setCreateTime(DateUtils.getNowDate());
        return evalTeachPersionMapper.insertEvalTeachPersion(evalTeachPersion);
    }

    /**
     * 修改老师个人测评
     * 
     * @param evalTeachPersion 老师个人测评
     * @return 结果
     */
    @Override
    public int updateEvalTeachPersion(EvalTeachPersion evalTeachPersion)
    {
        return evalTeachPersionMapper.updateEvalTeachPersion(evalTeachPersion);
    }

    /**
     * 批量删除老师个人测评
     * 
     * @param evalIds 需要删除的老师个人测评主键
     * @return 结果
     */
    @Override
    public int deleteEvalTeachPersionByEvalIds(Long[] evalIds)
    {
        return evalTeachPersionMapper.deleteEvalTeachPersionByEvalIds(evalIds);
    }

    /**
     * 删除老师个人测评信息
     * 
     * @param evalId 老师个人测评主键
     * @return 结果
     */
    @Override
    public int deleteEvalTeachPersionByEvalId(Long evalId)
    {
        return evalTeachPersionMapper.deleteEvalTeachPersionByEvalId(evalId);
    }
}
