package com.renhuas.basicdata.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.renhuas.common.annotation.Excel;
import com.renhuas.common.core.domain.BaseEntity;

/**
 * 学年信息对象 basicdata_sch_year
 * 
 * @author chenzr
 * @date 2021-11-04
 */
public class BasicdataSchYear extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long schYearId;

    /** 学年 */
    @Excel(name = "学年")
    private String schYear;

    /** 开始时间 */
    @Excel(name = "开始时间")
    private String startTime;

    /** 结束时间 */
    @Excel(name = "结束时间")
    private String endTime;

    /** 学习周 */
    @Excel(name = "学习周")
    private String studyWeek;

    public void setSchYearId(Long schYearId) 
    {
        this.schYearId = schYearId;
    }

    public Long getSchYearId() 
    {
        return schYearId;
    }
    public void setSchYear(String schYear) 
    {
        this.schYear = schYear;
    }

    public String getSchYear() 
    {
        return schYear;
    }
    public void setStartTime(String startTime) 
    {
        this.startTime = startTime;
    }

    public String getStartTime() 
    {
        return startTime;
    }
    public void setEndTime(String endTime) 
    {
        this.endTime = endTime;
    }

    public String getEndTime() 
    {
        return endTime;
    }
    public void setStudyWeek(String studyWeek) 
    {
        this.studyWeek = studyWeek;
    }

    public String getStudyWeek() 
    {
        return studyWeek;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("schYearId", getSchYearId())
            .append("schYear", getSchYear())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("studyWeek", getStudyWeek())
            .append("remark", getRemark())
            .toString();
    }
}
