package com.renhuas.eduplan.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.renhuas.common.annotation.Excel;
import com.renhuas.common.core.domain.BaseEntity;

/**
 * 方案管理对象 plan_edu
 * 
 * @author chenzr
 * @date 2021-11-05
 */
public class PlanEdu extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long planId;

    /** 方案名称 */
    @Excel(name = "方案名称")
    private String planName;

    /** 指标类型 */
    @Excel(name = "指标类型")
    private String tarType;

    /** 引用指标 */
    @Excel(name = "引用指标")
    private String refTar;

    /** 所属学年学期 */
    @Excel(name = "所属学年学期")
    private String schSemester;

    /** 描述 */
    @Excel(name = "描述")
    private String description;

    /** 用户ID */
    private Long userId;

    /** 创建人 */
    @Excel(name = "创建人")
    private String username;

    /** 引用状态 */
    @Excel(name = "引用状态")
    private String state;

    public void setPlanId(Long planId) 
    {
        this.planId = planId;
    }

    public Long getPlanId() 
    {
        return planId;
    }
    public void setPlanName(String planName) 
    {
        this.planName = planName;
    }

    public String getPlanName() 
    {
        return planName;
    }
    public void setTarType(String tarType) 
    {
        this.tarType = tarType;
    }

    public String getTarType() 
    {
        return tarType;
    }
    public void setRefTar(String refTar) 
    {
        this.refTar = refTar;
    }

    public String getRefTar() 
    {
        return refTar;
    }
    public void setSchSemester(String schSemester) 
    {
        this.schSemester = schSemester;
    }

    public String getSchSemester() 
    {
        return schSemester;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setUsername(String username) 
    {
        this.username = username;
    }

    public String getUsername() 
    {
        return username;
    }
    public void setState(String state) 
    {
        this.state = state;
    }

    public String getState() 
    {
        return state;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("planId", getPlanId())
            .append("planName", getPlanName())
            .append("tarType", getTarType())
            .append("refTar", getRefTar())
            .append("schSemester", getSchSemester())
            .append("description", getDescription())
            .append("createTime", getCreateTime())
            .append("userId", getUserId())
            .append("username", getUsername())
            .append("state", getState())
            .toString();
    }
}
