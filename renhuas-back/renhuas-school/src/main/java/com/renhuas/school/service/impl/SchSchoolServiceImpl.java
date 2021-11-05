package com.renhuas.school.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.renhuas.school.mapper.SchSchoolMapper;
import com.renhuas.school.domain.SchSchool;
import com.renhuas.school.service.ISchSchoolService;

/**
 * 学校信息Service业务层处理
 * 
 * @author chenzr
 * @date 2021-11-04
 */
@Service
public class SchSchoolServiceImpl implements ISchSchoolService 
{
    @Autowired
    private SchSchoolMapper schSchoolMapper;

    /**
     * 查询学校信息
     * 
     * @param schId 学校信息主键
     * @return 学校信息
     */
    @Override
    public SchSchool selectSchSchoolBySchId(Long schId)
    {
        return schSchoolMapper.selectSchSchoolBySchId(schId);
    }

    /**
     * 查询学校信息列表
     * 
     * @param schSchool 学校信息
     * @return 学校信息
     */
    @Override
    public List<SchSchool> selectSchSchoolList(SchSchool schSchool)
    {
        return schSchoolMapper.selectSchSchoolList(schSchool);
    }

    /**
     * 新增学校信息
     * 
     * @param schSchool 学校信息
     * @return 结果
     */
    @Override
    public int insertSchSchool(SchSchool schSchool)
    {
        return schSchoolMapper.insertSchSchool(schSchool);
    }

    /**
     * 修改学校信息
     * 
     * @param schSchool 学校信息
     * @return 结果
     */
    @Override
    public int updateSchSchool(SchSchool schSchool)
    {
        return schSchoolMapper.updateSchSchool(schSchool);
    }

    /**
     * 批量删除学校信息
     * 
     * @param schIds 需要删除的学校信息主键
     * @return 结果
     */
    @Override
    public int deleteSchSchoolBySchIds(Long[] schIds)
    {
        return schSchoolMapper.deleteSchSchoolBySchIds(schIds);
    }

    /**
     * 删除学校信息信息
     * 
     * @param schId 学校信息主键
     * @return 结果
     */
    @Override
    public int deleteSchSchoolBySchId(Long schId)
    {
        return schSchoolMapper.deleteSchSchoolBySchId(schId);
    }
}
