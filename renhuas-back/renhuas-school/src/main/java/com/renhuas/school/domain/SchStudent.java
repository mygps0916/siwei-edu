package com.renhuas.school.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.renhuas.common.annotation.Excel;
import com.renhuas.common.core.domain.BaseEntity;

/**
 * 学生信息对象 sch_student
 * 
 * @author chenzr
 * @date 2021-11-04
 */
public class SchStudent extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long stuId;

    /** 学生姓名 */
    @Excel(name = "学生姓名")
    private String stuName;

    /** 民族 */
    @Excel(name = "民族")
    private String stuNation;

    /** 性别 */
    @Excel(name = "性别")
    private String stuSex;

    /** 学校名称 */
    @Excel(name = "学校名称")
    private String schName;

    /** 学校ID */
    private String schId;

    /** 学籍号 */
    @Excel(name = "学籍号")
    private String schNum;

    /** 当前年级 */
    @Excel(name = "当前年级")
    private String grade;

    /** 班级ID */
    private Long classId;

    /** 当前班级 */
    @Excel(name = "当前班级")
    private String className;

    /** 籍贯 */
    @Excel(name = "籍贯")
    private String nativePlace;

    /** 常住地址 */
    @Excel(name = "常住地址")
    private String address;

    /** 监护人姓名 */
    @Excel(name = "监护人姓名")
    private String guardian;

    /** 监护人电话 */
    @Excel(name = "监护人电话")
    private String guardPhone;

    public void setStuId(Long stuId) 
    {
        this.stuId = stuId;
    }

    public Long getStuId() 
    {
        return stuId;
    }
    public void setStuName(String stuName) 
    {
        this.stuName = stuName;
    }

    public String getStuName() 
    {
        return stuName;
    }
    public void setStuNation(String stuNation) 
    {
        this.stuNation = stuNation;
    }

    public String getStuNation() 
    {
        return stuNation;
    }
    public void setStuSex(String stuSex) 
    {
        this.stuSex = stuSex;
    }

    public String getStuSex() 
    {
        return stuSex;
    }
    public void setSchName(String schName) 
    {
        this.schName = schName;
    }

    public String getSchName() 
    {
        return schName;
    }
    public void setSchId(String schId) 
    {
        this.schId = schId;
    }

    public String getSchId() 
    {
        return schId;
    }
    public void setSchNum(String schNum) 
    {
        this.schNum = schNum;
    }

    public String getSchNum() 
    {
        return schNum;
    }
    public void setGrade(String grade) 
    {
        this.grade = grade;
    }

    public String getGrade() 
    {
        return grade;
    }
    public void setClassId(Long classId) 
    {
        this.classId = classId;
    }

    public Long getClassId() 
    {
        return classId;
    }
    public void setClassName(String className) 
    {
        this.className = className;
    }

    public String getClassName() 
    {
        return className;
    }
    public void setNativePlace(String nativePlace) 
    {
        this.nativePlace = nativePlace;
    }

    public String getNativePlace() 
    {
        return nativePlace;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setGuardian(String guardian) 
    {
        this.guardian = guardian;
    }

    public String getGuardian() 
    {
        return guardian;
    }
    public void setGuardPhone(String guardPhone) 
    {
        this.guardPhone = guardPhone;
    }

    public String getGuardPhone() 
    {
        return guardPhone;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("stuId", getStuId())
            .append("stuName", getStuName())
            .append("stuNation", getStuNation())
            .append("stuSex", getStuSex())
            .append("schName", getSchName())
            .append("schId", getSchId())
            .append("schNum", getSchNum())
            .append("grade", getGrade())
            .append("classId", getClassId())
            .append("className", getClassName())
            .append("nativePlace", getNativePlace())
            .append("address", getAddress())
            .append("guardian", getGuardian())
            .append("guardPhone", getGuardPhone())
            .toString();
    }
}
