package com.renhuas.evalanalyze.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.renhuas.common.annotation.Excel;
import com.renhuas.common.core.domain.BaseEntity;

/**
 * 学校测评分析对象 analyze_sch_eval
 * 
 * @author chenzr
 * @date 2021-11-04
 */
public class AnalyzeSchEval extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long analyzeId;

    /** 学校名称 */
    @Excel(name = "学校名称")
    private String schName;

    /** 学校ID */
    private Long schId;

    /** 学年 */
    @Excel(name = "学年")
    private String schYear;

    /** 学期 */
    @Excel(name = "学期")
    private String semester;

    /** 测评得分 */
    @Excel(name = "测评得分")
    private Long evalScore;

    /** 排名 */
    @Excel(name = "排名")
    private String ranking;

    public void setAnalyzeId(Long analyzeId) 
    {
        this.analyzeId = analyzeId;
    }

    public Long getAnalyzeId() 
    {
        return analyzeId;
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
    public void setSchYear(String schYear) 
    {
        this.schYear = schYear;
    }

    public String getSchYear() 
    {
        return schYear;
    }
    public void setSemester(String semester) 
    {
        this.semester = semester;
    }

    public String getSemester() 
    {
        return semester;
    }
    public void setEvalScore(Long evalScore) 
    {
        this.evalScore = evalScore;
    }

    public Long getEvalScore() 
    {
        return evalScore;
    }
    public void setRanking(String ranking) 
    {
        this.ranking = ranking;
    }

    public String getRanking() 
    {
        return ranking;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("analyzeId", getAnalyzeId())
            .append("schName", getSchName())
            .append("schId", getSchId())
            .append("schYear", getSchYear())
            .append("semester", getSemester())
            .append("createTime", getCreateTime())
            .append("evalScore", getEvalScore())
            .append("ranking", getRanking())
            .toString();
    }
}
