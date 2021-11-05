package com.renhuas.basicdata.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.renhuas.common.annotation.Excel;
import com.renhuas.common.core.domain.BaseEntity;

/**
 * 平均分数对象 basicdata_average_score
 * 
 * @author chenzr
 * @date 2021-11-04
 */
public class BasicdataAverageScore extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long averageScoreId;

    /** 科目 */
    @Excel(name = "科目")
    private String course;

    /** 科目ID */
    private Long courseId;

    /** 平均分数 */
    @Excel(name = "平均分数")
    private String averageScore;

    /** 类型 */
    @Excel(name = "类型")
    private String averType;

    /** 学业阶段 */
    @Excel(name = "学业阶段")
    private String academic;

    /** 学年 */
    @Excel(name = "学年")
    private String schYear;

    /** 学年ID */
    private Long schYearId;

    /** 学期 */
    @Excel(name = "学期")
    private String semester;

    /** 学期ID */
    private Long semesterId;

    /** 年级 */
    @Excel(name = "年级")
    private String grade;

    /** 年级ID */
    @Excel(name = "年级ID")
    private Long gradeId;

    public void setAverageScoreId(Long averageScoreId) 
    {
        this.averageScoreId = averageScoreId;
    }

    public Long getAverageScoreId() 
    {
        return averageScoreId;
    }
    public void setCourse(String course) 
    {
        this.course = course;
    }

    public String getCourse() 
    {
        return course;
    }
    public void setCourseId(Long courseId) 
    {
        this.courseId = courseId;
    }

    public Long getCourseId() 
    {
        return courseId;
    }
    public void setAverageScore(String averageScore) 
    {
        this.averageScore = averageScore;
    }

    public String getAverageScore() 
    {
        return averageScore;
    }
    public void setAverType(String averType) 
    {
        this.averType = averType;
    }

    public String getAverType() 
    {
        return averType;
    }
    public void setAcademic(String academic) 
    {
        this.academic = academic;
    }

    public String getAcademic() 
    {
        return academic;
    }
    public void setSchYear(String schYear) 
    {
        this.schYear = schYear;
    }

    public String getSchYear() 
    {
        return schYear;
    }
    public void setSchYearId(Long schYearId) 
    {
        this.schYearId = schYearId;
    }

    public Long getSchYearId() 
    {
        return schYearId;
    }
    public void setSemester(String semester) 
    {
        this.semester = semester;
    }

    public String getSemester() 
    {
        return semester;
    }
    public void setSemesterId(Long semesterId) 
    {
        this.semesterId = semesterId;
    }

    public Long getSemesterId() 
    {
        return semesterId;
    }
    public void setGrade(String grade) 
    {
        this.grade = grade;
    }

    public String getGrade() 
    {
        return grade;
    }
    public void setGradeId(Long gradeId) 
    {
        this.gradeId = gradeId;
    }

    public Long getGradeId() 
    {
        return gradeId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("averageScoreId", getAverageScoreId())
            .append("course", getCourse())
            .append("courseId", getCourseId())
            .append("averageScore", getAverageScore())
            .append("averType", getAverType())
            .append("academic", getAcademic())
            .append("schYear", getSchYear())
            .append("schYearId", getSchYearId())
            .append("semester", getSemester())
            .append("semesterId", getSemesterId())
            .append("grade", getGrade())
            .append("gradeId", getGradeId())
            .append("remark", getRemark())
            .toString();
    }
}
