package com.renhuas.school.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.renhuas.school.mapper.SchClassMapper;
import com.renhuas.school.domain.SchClass;
import com.renhuas.school.service.ISchClassService;

/**
 * 班级信息Service业务层处理
 * 
 * @author chenzr
 * @date 2021-11-04
 */
@Service
public class SchClassServiceImpl implements ISchClassService 
{
    @Autowired
    private SchClassMapper schClassMapper;

    /**
     * 查询班级信息
     * 
     * @param classId 班级信息主键
     * @return 班级信息
     */
    @Override
    public SchClass selectSchClassByClassId(Long classId)
    {
        return schClassMapper.selectSchClassByClassId(classId);
    }

    /**
     * 查询班级信息列表
     * 
     * @param schClass 班级信息
     * @return 班级信息
     */
    @Override
    public List<SchClass> selectSchClassList(SchClass schClass)
    {
        return schClassMapper.selectSchClassList(schClass);
    }

    /**
     * 新增班级信息
     * 
     * @param schClass 班级信息
     * @return 结果
     */
    @Override
    public int insertSchClass(SchClass schClass)
    {
        return schClassMapper.insertSchClass(schClass);
    }

    /**
     * 修改班级信息
     * 
     * @param schClass 班级信息
     * @return 结果
     */
    @Override
    public int updateSchClass(SchClass schClass)
    {
        return schClassMapper.updateSchClass(schClass);
    }

    /**
     * 批量删除班级信息
     * 
     * @param classIds 需要删除的班级信息主键
     * @return 结果
     */
    @Override
    public int deleteSchClassByClassIds(Long[] classIds)
    {
        return schClassMapper.deleteSchClassByClassIds(classIds);
    }

    /**
     * 删除班级信息信息
     * 
     * @param classId 班级信息主键
     * @return 结果
     */
    @Override
    public int deleteSchClassByClassId(Long classId)
    {
        return schClassMapper.deleteSchClassByClassId(classId);
    }
}
