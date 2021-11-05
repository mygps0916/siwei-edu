package com.renhuas.school.service;

import java.util.List;
import com.renhuas.school.domain.SchClass;

/**
 * 班级信息Service接口
 * 
 * @author chenzr
 * @date 2021-11-04
 */
public interface ISchClassService 
{
    /**
     * 查询班级信息
     * 
     * @param classId 班级信息主键
     * @return 班级信息
     */
    public SchClass selectSchClassByClassId(Long classId);

    /**
     * 查询班级信息列表
     * 
     * @param schClass 班级信息
     * @return 班级信息集合
     */
    public List<SchClass> selectSchClassList(SchClass schClass);

    /**
     * 新增班级信息
     * 
     * @param schClass 班级信息
     * @return 结果
     */
    public int insertSchClass(SchClass schClass);

    /**
     * 修改班级信息
     * 
     * @param schClass 班级信息
     * @return 结果
     */
    public int updateSchClass(SchClass schClass);

    /**
     * 批量删除班级信息
     * 
     * @param classIds 需要删除的班级信息主键集合
     * @return 结果
     */
    public int deleteSchClassByClassIds(Long[] classIds);

    /**
     * 删除班级信息信息
     * 
     * @param classId 班级信息主键
     * @return 结果
     */
    public int deleteSchClassByClassId(Long classId);
}
