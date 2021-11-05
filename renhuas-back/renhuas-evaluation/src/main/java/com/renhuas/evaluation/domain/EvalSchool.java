package com.renhuas.evaluation.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.renhuas.common.annotation.Excel;
import com.renhuas.common.core.domain.BaseEntity;

/**
 * 学校测评对象 eval_school
 * 
 * @author chenzr
 * @date 2021-11-04
 */
public class EvalSchool extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long evalId;

    /** 总表名称 */
    @Excel(name = "总表名称")
    private String evalName;

    /** 学业阶段 */
    @Excel(name = "学业阶段")
    private String academic;

    /** 所属学年学期 */
    @Excel(name = "所属学年学期")
    private String schSemester;

    /** 测评方案名称 */
    @Excel(name = "测评方案名称")
    private String evalPlanName;

    /** 用户ID */
    private Long userId;

    /** 创建人 */
    @Excel(name = "创建人")
    private String username;

    /** 引用状态 */
    @Excel(name = "引用状态")
    private String refState;

    public void setEvalId(Long evalId) 
    {
        this.evalId = evalId;
    }

    public Long getEvalId() 
    {
        return evalId;
    }
    public void setEvalName(String evalName) 
    {
        this.evalName = evalName;
    }

    public String getEvalName() 
    {
        return evalName;
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
    public void setEvalPlanName(String evalPlanName) 
    {
        this.evalPlanName = evalPlanName;
    }

    public String getEvalPlanName() 
    {
        return evalPlanName;
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
    public void setRefState(String refState) 
    {
        this.refState = refState;
    }

    public String getRefState() 
    {
        return refState;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("evalId", getEvalId())
            .append("evalName", getEvalName())
            .append("academic", getAcademic())
            .append("schSemester", getSchSemester())
            .append("evalPlanName", getEvalPlanName())
            .append("createTime", getCreateTime())
            .append("userId", getUserId())
            .append("username", getUsername())
            .append("refState", getRefState())
            .toString();
    }
}
