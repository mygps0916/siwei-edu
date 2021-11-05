package com.renhuas.edutrace.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.renhuas.common.annotation.Excel;
import com.renhuas.common.core.domain.BaseEntity;

/**
 * 学校教学追溯对象 trace_edu_sch
 * 
 * @author chenzr
 * @date 2021-11-04
 */
public class TraceEduSch extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long traceId;

    /** 统计名称 */
    @Excel(name = "统计名称")
    private String traceName;

    /** 学校名称 */
    @Excel(name = "学校名称")
    private String schName;

    /** 学校ID */
    private Long schId;

    /** 年级 */
    @Excel(name = "年级")
    private String grade;

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
    public void setGrade(String grade) 
    {
        this.grade = grade;
    }

    public String getGrade() 
    {
        return grade;
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
            .append("schName", getSchName())
            .append("schId", getSchId())
            .append("grade", getGrade())
            .append("countTime", getCountTime())
            .append("createTime", getCreateTime())
            .append("username", getUsername())
            .append("userId", getUserId())
            .toString();
    }
}
