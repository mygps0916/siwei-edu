package com.renhuas.school.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.renhuas.common.annotation.Excel;
import com.renhuas.common.core.domain.BaseEntity;

/**
 * 教师信息对象 sch_teacher
 * 
 * @author chenzr
 * @date 2021-11-04
 */
public class SchTeacher extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long teachId;

    /** 教师姓名 */
    @Excel(name = "教师姓名")
    private String teachName;

    /** 老师性别 */
    @Excel(name = "老师性别")
    private String teachSex;

    /** 出生日期 */
    @Excel(name = "出生日期")
    private String birthDate;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String cartId;

    /** 职称 */
    @Excel(name = "职称")
    private String jobTitle;

    /** 任教学校 */
    @Excel(name = "任教学校")
    private String schName;

    /** 学校ID */
    private Long schId;

    /** 学校类型 */
    @Excel(name = "学校类型")
    private String schType;

    /** 任教科目 */
    @Excel(name = "任教科目")
    private String course;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String telephone;

    public void setTeachId(Long teachId) 
    {
        this.teachId = teachId;
    }

    public Long getTeachId() 
    {
        return teachId;
    }
    public void setTeachName(String teachName) 
    {
        this.teachName = teachName;
    }

    public String getTeachName() 
    {
        return teachName;
    }
    public void setTeachSex(String teachSex) 
    {
        this.teachSex = teachSex;
    }

    public String getTeachSex() 
    {
        return teachSex;
    }
    public void setBirthDate(String birthDate) 
    {
        this.birthDate = birthDate;
    }

    public String getBirthDate() 
    {
        return birthDate;
    }
    public void setCartId(String cartId) 
    {
        this.cartId = cartId;
    }

    public String getCartId() 
    {
        return cartId;
    }
    public void setJobTitle(String jobTitle) 
    {
        this.jobTitle = jobTitle;
    }

    public String getJobTitle() 
    {
        return jobTitle;
    }
    public void setSchName(String schName) 
    {
        this.schName = schName;
    }

    public String getSchName() 
    {
        return schName;
    }
    public void setSchId(Long schId) 
    {
        this.schId = schId;
    }

    public Long getSchId() 
    {
        return schId;
    }
    public void setSchType(String schType) 
    {
        this.schType = schType;
    }

    public String getSchType() 
    {
        return schType;
    }
    public void setCourse(String course) 
    {
        this.course = course;
    }

    public String getCourse() 
    {
        return course;
    }
    public void setTelephone(String telephone) 
    {
        this.telephone = telephone;
    }

    public String getTelephone() 
    {
        return telephone;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("teachId", getTeachId())
            .append("teachName", getTeachName())
            .append("teachSex", getTeachSex())
            .append("birthDate", getBirthDate())
            .append("cartId", getCartId())
            .append("jobTitle", getJobTitle())
            .append("schName", getSchName())
            .append("schId", getSchId())
            .append("schType", getSchType())
            .append("course", getCourse())
            .append("telephone", getTelephone())
            .toString();
    }
}
