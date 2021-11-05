package com.renhuas.evaluation.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.renhuas.common.annotation.Excel;
import com.renhuas.common.core.domain.BaseEntity;

/**
 * 教学质量评测对象 eval_edu_quality
 * 
 * @author chenzr
 * @date 2021-11-04
 */
public class EvalEduQuality extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long techQualityId;

    /** 教学质量报告 */
    @Excel(name = "教学质量报告")
    private String techQualityName;

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

    public void setTechQualityId(Long techQualityId) 
    {
        this.techQualityId = techQualityId;
    }

    public Long getTechQualityId() 
    {
        return techQualityId;
    }
    public void setTechQualityName(String techQualityName) 
    {
        this.techQualityName = techQualityName;
    }

    public String getTechQualityName() 
    {
        return techQualityName;
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
            .append("techQualityId", getTechQualityId())
            .append("techQualityName", getTechQualityName())
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
