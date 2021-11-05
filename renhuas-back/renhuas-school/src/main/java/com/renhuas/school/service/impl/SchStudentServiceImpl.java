package com.renhuas.school.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.renhuas.school.mapper.SchStudentMapper;
import com.renhuas.school.domain.SchStudent;
import com.renhuas.school.service.ISchStudentService;

/**
 * 学生信息Service业务层处理
 * 
 * @author chenzr
 * @date 2021-11-04
 */
@Service
public class SchStudentServiceImpl implements ISchStudentService 
{
    @Autowired
    private SchStudentMapper schStudentMapper;

    /**
     * 查询学生信息
     * 
     * @param stuId 学生信息主键
     * @return 学生信息
     */
    @Override
    public SchStudent selectSchStudentByStuId(Long stuId)
    {
        return schStudentMapper.selectSchStudentByStuId(stuId);
    }

    /**
     * 查询学生信息列表
     * 
     * @param schStudent 学生信息
     * @return 学生信息
     */
    @Override
    public List<SchStudent> selectSchStudentList(SchStudent schStudent)
    {
        return schStudentMapper.selectSchStudentList(schStudent);
    }

    /**
     * 新增学生信息
     * 
     * @param schStudent 学生信息
     * @return 结果
     */
    @Override
    public int insertSchStudent(SchStudent schStudent)
    {
        return schStudentMapper.insertSchStudent(schStudent);
    }

    /**
     * 修改学生信息
     * 
     * @param schStudent 学生信息
     * @return 结果
     */
    @Override
    public int updateSchStudent(SchStudent schStudent)
    {
        return schStudentMapper.updateSchStudent(schStudent);
    }

    /**
     * 批量删除学生信息
     * 
     * @param stuIds 需要删除的学生信息主键
     * @return 结果
     */
    @Override
    public int deleteSchStudentByStuIds(Long[] stuIds)
    {
        return schStudentMapper.deleteSchStudentByStuIds(stuIds);
    }

    /**
     * 删除学生信息信息
     * 
     * @param stuId 学生信息主键
     * @return 结果
     */
    @Override
    public int deleteSchStudentByStuId(Long stuId)
    {
        return schStudentMapper.deleteSchStudentByStuId(stuId);
    }
}
