package com.renhuas.school.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.renhuas.common.annotation.Excel;
import com.renhuas.common.core.domain.BaseEntity;

/**
 * 班级信息对象 sch_class
 * 
 * @author chenzr
 * @date 2021-11-04
 */
public class SchClass extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long classId;

    /** 班级名称 */
    @Excel(name = "班级名称")
    private String className;

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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("classId", getClassId())
            .append("className", getClassName())
            .append("remark", getRemark())
            .toString();
    }
}
