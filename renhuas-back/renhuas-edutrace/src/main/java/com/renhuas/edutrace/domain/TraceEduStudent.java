package com.renhuas.edutrace.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.renhuas.common.annotation.Excel;
import com.renhuas.common.core.domain.BaseEntity;

/**
 * 学生教学质量追溯对象 trace_edu_student
 * 
 * @author chenzr
 * @date 2021-11-04
 */
public class TraceEduStudent extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long traceId;

    /** 学生教学追溯报告名称 */
    @Excel(name = "学生教学追溯报告名称")
    private String traceName;

    /** 学业阶段 */
    @Excel(name = "学业阶段")
    private String academic;

    /** 学生姓名 */
    @Excel(name = "学生姓名")
    private String stuName;

    /** 学籍号（身份证号） */
    @Excel(name = "学籍号", readConverterExp = "身=份证号")
    private String schNum;

    /** 统计时间 */
    @Excel(name = "统计时间")
    private String countTime;

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
    public void setStuName(String stuName) 
    {
        this.stuName = stuName;
    }

    public String getStuName() 
    {
        return stuName;
    }
    public void setSchNum(String schNum) 
    {
        this.schNum = schNum;
    }

    public String getSchNum() 
    {
        return schNum;
    }
    public void setCountTime(String countTime) 
    {
        this.countTime = countTime;
    }

    public String getCountTime() 
    {
        return countTime;
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
            .append("stuName", getStuName())
            .append("schNum", getSchNum())
            .append("countTime", getCountTime())
            .append("createTime", getCreateTime())
            .append("username", getUsername())
            .append("userId", getUserId())
            .toString();
    }
}
