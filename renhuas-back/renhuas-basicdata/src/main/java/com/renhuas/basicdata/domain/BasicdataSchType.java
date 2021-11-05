package com.renhuas.basicdata.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.renhuas.common.annotation.Excel;
import com.renhuas.common.core.domain.BaseEntity;

/**
 * 学校类型对象 basicdata_sch_type
 * 
 * @author chenzr
 * @date 2021-11-04
 */
public class BasicdataSchType extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long schTypeId;

    /** 学校类型 */
    @Excel(name = "学校类型")
    private String schType;

    public void setSchTypeId(Long schTypeId) 
    {
        this.schTypeId = schTypeId;
    }

    public Long getSchTypeId() 
    {
        return schTypeId;
    }
    public void setSchType(String schType) 
    {
        this.schType = schType;
    }

    public String getSchType() 
    {
        return schType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("schTypeId", getSchTypeId())
            .append("schType", getSchType())
            .append("remark", getRemark())
            .toString();
    }
}
