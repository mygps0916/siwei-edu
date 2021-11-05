package com.renhuas.evaluation.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.renhuas.common.annotation.Excel;
import com.renhuas.common.core.domain.BaseEntity;

/**
 * 老师个人测评对象 eval_teach_persion
 * 
 * @author chenzr
 * @date 2021-11-04
 */
public class EvalTeachPersion extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long evalId;

    /** 老师个人报告名称 */
    @Excel(name = "老师个人报告名称")
    private String evalPersionName;

    /** 学业阶段 */
    @Excel(name = "学业阶段")
    private String academic;

    /** 所属学年学期 */
    @Excel(name = "所属学年学期")
    private String schSemester;

    /** 客观评价 */
    @Excel(name = "客观评价")
    private String evalObjective;

    /** 主观评价 */
    @Excel(name = "主观评价")
    private String evalSubjective;

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
    public void setEvalPersionName(String evalPersionName) 
    {
        this.evalPersionName = evalPersionName;
    }

    public String getEvalPersionName() 
    {
        return evalPersionName;
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
    public void setEvalObjective(String evalObjective) 
    {
        this.evalObjective = evalObjective;
    }

    public String getEvalObjective() 
    {
        return evalObjective;
    }
    public void setEvalSubjective(String evalSubjective) 
    {
        this.evalSubjective = evalSubjective;
    }

    public String getEvalSubjective() 
    {
        return evalSubjective;
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
            .append("evalPersionName", getEvalPersionName())
            .append("academic", getAcademic())
            .append("schSemester", getSchSemester())
            .append("evalObjective", getEvalObjective())
            .append("evalSubjective", getEvalSubjective())
            .append("createTime", getCreateTime())
            .append("userId", getUserId())
            .append("username", getUsername())
            .toString();
    }
}
