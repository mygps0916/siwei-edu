package com.renhuas.basicdata.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.renhuas.common.annotation.Excel;
import com.renhuas.common.core.domain.BaseEntity;

/**
 * 科目信息对象 basicdata_course
 * 
 * @author chenzr
 * @date 2021-11-04
 */
public class BasicdataCourse extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 科目ID */
    private Long courseId;

    /** 科目 */
    @Excel(name = "科目")
    private String course;

    public void setCourseId(Long courseId) 
    {
        this.courseId = courseId;
    }

    public Long getCourseId() 
    {
        return courseId;
    }
    public void setCourse(String course) 
    {
        this.course = course;
    }

    public String getCourse() 
    {
        return course;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("courseId", getCourseId())
            .append("course", getCourse())
            .append("remark", getRemark())
            .toString();
    }
}
