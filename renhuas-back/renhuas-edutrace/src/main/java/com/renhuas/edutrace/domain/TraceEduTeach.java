package com.renhuas.edutrace.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.renhuas.common.annotation.Excel;
import com.renhuas.common.core.domain.BaseEntity;

/**
 * 老师教学追溯对象 trace_edu_teach
 * 
 * @author chenzr
 * @date 2021-11-04
 */
public class TraceEduTeach extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long traceId;

    /** 老师追溯报告名称 */
    @Excel(name = "老师追溯报告名称")
    private String traceName;

    /** 学业阶段 */
    @Excel(name = "学业阶段")
    private String academic;

    /** 所属学年学期 */
    @Excel(name = "所属学年学期")
    private String schSemester;

    /** 客观评价 */
    @Excel(name = "客观评价")
    private String objEval;

    /** 主观评价 */
    @Excel(name = "主观评价")
    private String subjEval;

    /** 创建人 */
    @Excel(name = "创建人")
    private String username;

    /** 用户ID */
    private Long userId;

    public void setTraceId(Long traceId) 
    {
        this.traceId = traceId;
    }

    public Long getTraceId() 
    {
        return traceId;
    }
    public void setTraceName(String traceName) 
    {
        this.traceName = traceName;
    }

    public String getTraceName() 
    {
        return traceName;
    }
    public void setAcademic(String academic) 
    {
        this.academic = academic;
    }

    public String getAcademic() 
    {
        return academic;
    }
    public void setSchSemester(String schSemester) 
    {
        this.schSemester = schSemester;
    }

    public String getSchSemester() 
    {
        return schSemester;
    }
    public void setObjEval(String objEval) 
    {
        this.objEval = objEval;
    }

    public String getObjEval() 
    {
        return objEval;
    }
    public void setSubjEval(String subjEval) 
    {
        this.subjEval = subjEval;
    }

    public String getSubjEval() 
    {
        return subjEval;
    }
    public void setUsername(String username) 
    {
        this.username = username;
    }

    public String getUsername() 
    {
        return username;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("traceId", getTraceId())
            .append("traceName", getTraceName())
            .append("academic", getAcademic())
            .append("schSemester", getSchSemester())
            .append("objEval", getObjEval())
            .append("subjEval", getSubjEval())
            .append("createTime", getCreateTime())
            .append("username", getUsername())
            .append("userId", getUserId())
            .toString();
    }
}
