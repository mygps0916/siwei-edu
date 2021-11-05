package com.renhuas.school.mapper;

import java.util.List;
import com.renhuas.school.domain.SchTeacher;

/**
 * 教师信息Mapper接口
 * 
 * @author chenzr
 * @date 2021-11-04
 */
public interface SchTeacherMapper 
{
    /**
     * 查询教师信息
     * 
     * @param teachId 教师信息主键
     * @return 教师信息
     */
    public SchTeacher selectSchTeacherByTeachId(Long teachId);

    /**
     * 查询教师信息列表
     * 
     * @param schTeacher 教师信息
     * @return 教师信息集合
     */
    public List<SchTeacher> selectSchTeacherList(SchTeacher schTeacher);

    /**
     * 新增教师信息
     * 
     * @param schTeacher 教师信息
     * @return 结果
     */
    public int insertSchTeacher(SchTeacher schTeacher);

    /**
     * 修改教师信息
     * 
     * @param schTeacher 教师信息
     * @return 结果
     */
    public int updateSchTeacher(SchTeacher schTeacher);

    /**
     * 删除教师信息
     * 
     * @param teachId 教师信息主键
     * @return 结果
     */
    public int deleteSchTeacherByTeachId(Long teachId);

    /**
     * 批量删除教师信息
     * 
     * @param teachIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSchTeacherByTeachIds(Long[] teachIds);
}
