package com.renhuas.school.mapper;

import java.util.List;
import com.renhuas.school.domain.SchStudent;

/**
 * 学生信息Mapper接口
 * 
 * @author chenzr
 * @date 2021-11-04
 */
public interface SchStudentMapper 
{
    /**
     * 查询学生信息
     * 
     * @param stuId 学生信息主键
     * @return 学生信息
     */
    public SchStudent selectSchStudentByStuId(Long stuId);

    /**
     * 查询学生信息列表
     * 
     * @param schStudent 学生信息
     * @return 学生信息集合
     */
    public List<SchStudent> selectSchStudentList(SchStudent schStudent);

    /**
     * 新增学生信息
     * 
     * @param schStudent 学生信息
     * @return 结果
     */
    public int insertSchStudent(SchStudent schStudent);

    /**
     * 修改学生信息
     * 
     * @param schStudent 学生信息
     * @return 结果
     */
    public int updateSchStudent(SchStudent schStudent);

    /**
     * 删除学生信息
     * 
     * @param stuId 学生信息主键
     * @return 结果
     */
    public int deleteSchStudentByStuId(Long stuId);

    /**
     * 批量删除学生信息
     * 
     * @param stuIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSchStudentByStuIds(Long[] stuIds);
}
