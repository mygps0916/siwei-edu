package com.renhuas.school.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.renhuas.school.mapper.SchTeacherMapper;
import com.renhuas.school.domain.SchTeacher;
import com.renhuas.school.service.ISchTeacherService;

/**
 * 教师信息Service业务层处理
 * 
 * @author chenzr
 * @date 2021-11-04
 */
@Service
public class SchTeacherServiceImpl implements ISchTeacherService 
{
    @Autowired
    private SchTeacherMapper schTeacherMapper;

    /**
     * 查询教师信息
     * 
     * @param teachId 教师信息主键
     * @return 教师信息
     */
    @Override
    public SchTeacher selectSchTeacherByTeachId(Long teachId)
    {
        return schTeacherMapper.selectSchTeacherByTeachId(teachId);
    }

    /**
     * 查询教师信息列表
     * 
     * @param schTeacher 教师信息
     * @return 教师信息
     */
    @Override
    public List<SchTeacher> selectSchTeacherList(SchTeacher schTeacher)
    {
        return schTeacherMapper.selectSchTeacherList(schTeacher);
    }

    /**
     * 新增教师信息
     * 
     * @param schTeacher 教师信息
     * @return 结果
     */
    @Override
    public int insertSchTeacher(SchTeacher schTeacher)
    {
        return schTeacherMapper.insertSchTeacher(schTeacher);
    }

    /**
     * 修改教师信息
     * 
     * @param schTeacher 教师信息
     * @return 结果
     */
    @Override
    public int updateSchTeacher(SchTeacher schTeacher)
    {
        return schTeacherMapper.updateSchTeacher(schTeacher);
    }

    /**
     * 批量删除教师信息
     * 
     * @param teachIds 需要删除的教师信息主键
     * @return 结果
     */
    @Override
    public int deleteSchTeacherByTeachIds(Long[] teachIds)
    {
        return schTeacherMapper.deleteSchTeacherByTeachIds(teachIds);
    }

    /**
     * 删除教师信息信息
     * 
     * @param teachId 教师信息主键
     * @return 结果
     */
    @Override
    public int deleteSchTeacherByTeachId(Long teachId)
    {
        return schTeacherMapper.deleteSchTeacherByTeachId(teachId);
    }
}
