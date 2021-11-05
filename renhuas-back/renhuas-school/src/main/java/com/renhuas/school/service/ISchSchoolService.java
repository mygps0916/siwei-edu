package com.renhuas.school.service;

import java.util.List;
import com.renhuas.school.domain.SchSchool;

/**
 * 学校信息Service接口
 * 
 * @author chenzr
 * @date 2021-11-04
 */
public interface ISchSchoolService 
{
    /**
     * 查询学校信息
     * 
     * @param schId 学校信息主键
     * @return 学校信息
     */
    public SchSchool selectSchSchoolBySchId(Long schId);

    /**
     * 查询学校信息列表
     * 
     * @param schSchool 学校信息
     * @return 学校信息集合
     */
    public List<SchSchool> selectSchSchoolList(SchSchool schSchool);

    /**
     * 新增学校信息
     * 
     * @param schSchool 学校信息
     * @return 结果
     */
    public int insertSchSchool(SchSchool schSchool);

    /**
     * 修改学校信息
     * 
     * @param schSchool 学校信息
     * @return 结果
     */
    public int updateSchSchool(SchSchool schSchool);

    /**
     * 批量删除学校信息
     * 
     * @param schIds 需要删除的学校信息主键集合
     * @return 结果
     */
    public int deleteSchSchoolBySchIds(Long[] schIds);

    /**
     * 删除学校信息信息
     * 
     * @param schId 学校信息主键
     * @return 结果
     */
    public int deleteSchSchoolBySchId(Long schId);
}
