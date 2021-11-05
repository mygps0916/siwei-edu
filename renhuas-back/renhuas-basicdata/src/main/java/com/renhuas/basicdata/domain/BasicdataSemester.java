package com.renhuas.basicdata.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.renhuas.common.annotation.Excel;
import com.renhuas.common.core.domain.BaseEntity;

/**
 * 学期信息对象 basicdata_semester
 * 
 * @author chenzr
 * @date 2021-11-04
 */
public class BasicdataSemester extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long semesterId;

    /** 学期 */
    @Excel(name = "学期")
    private String semester;

    /** 学习周 */
    @Excel(name = "学习周")
    private String studyWeek;

    public void setSemesterId(Long semesterId) 
    {
        this.semesterId = semesterId;
    }

    public Long getSemesterId() 
    {
        return semesterId;
    }
    public void setSemester(String semester) 
    {
        this.semester = semester;
    }

    public String getSemester() 
    {
        return semester;
    }
    public void setStudyWeek(String studyWeek) 
    {
        this.studyWeek = studyWeek;
    }

    public String getStudyWeek() 
    {
        return studyWeek;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("semesterId", getSemesterId())
            .append("semester", getSemester())
            .append("studyWeek", getStudyWeek())
            .append("remark", getRemark())
            .toString();
    }
}
