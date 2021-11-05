package com.renhuas.evaluation.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.renhuas.common.annotation.Excel;
import com.renhuas.common.core.domain.BaseEntity;

/**
 * 老师教学测评对象 eval_teacher
 * 
 * @author chenzr
 * @date 2021-11-04
 */
public class EvalTeacher extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long evalId;

    /** 老师测评汇总名称 */
    @Excel(name = "老师测评汇总名称")
    private String evalTeachName;

    /** 学业阶段 */
    @Excel(name = "学业阶段")
    private String academic;

    /** 所属学年学期 */
    @Excel(name = "所属学年学期")
    private String schSemester;

    /** 评测方案名称 */
    @Excel(name = "评测方案名称")
    private String evalPlan;

    /** 引用状态 */
    @Excel(name = "引用状态")
    private String refState;

    /** 用户ID */
    private Long userId;

    /** 创建人 */
    @Excel(name = "创建人")
    private String username;

    public void setEvalId(Long evalId) 
    {
        this.evalId = evalId;
    }

    public Long getEvalId() 
    {
        return evalId;
    }
    public void setEvalTeachName(String evalTeachName) 
    {
        this.evalTeachName = evalTeachName;
    }

    public String getEvalTeachName() 
    {
        return evalTeachName;
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
    public void setEvalPlan(String evalPlan) 
    {
        this.evalPlan = evalPlan;
    }

    public String getEvalPlan() 
    {
        return evalPlan;
    }
    public void setRefState(String refState) 
    {
        this.refState = refState;
    }

    public String getRefState() 
    {
        return refState;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("evalId", getEvalId())
            .append("evalTeachName", getEvalTeachName())
            .append("academic", getAcademic())
            .append("schSemester", getSchSemester())
            .append("evalPlan", getEvalPlan())
            .append("createTime", getCreateTime())
            .append("refState", getRefState())
            .append("userId", getUserId())
            .append("username", getUsername())
            .toString();
    }
}
