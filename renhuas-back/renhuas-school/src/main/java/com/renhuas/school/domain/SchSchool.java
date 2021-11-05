package com.renhuas.school.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.renhuas.common.annotation.Excel;
import com.renhuas.common.core.domain.BaseEntity;

/**
 * 学校信息对象 sch_school
 * 
 * @author chenzr
 * @date 2021-11-04
 */
public class SchSchool extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long schId;

    /** 学校名称 */
    @Excel(name = "学校名称")
    private String schName;

    /** 学校类型 */
    @Excel(name = "学校类型")
    private String schType;

    /** 学校代码 */
    @Excel(name = "学校代码")
    private String schCode;

    /** 所属区域 */
    @Excel(name = "所属区域")
    private String region;

    /** 地址 */
    @Excel(name = "地址")
    private String address;

    /** 联系人 */
    @Excel(name = "联系人")
    private String linkName;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String linkPhone;

    /** 学校简介 */
    @Excel(name = "学校简介")
    private String schProfile;

    public void setSchId(Long schId) 
    {
        this.schId = schId;
    }

    public Long getSchId() 
    {
        return schId;
    }
    public void setSchName(String schName) 
    {
        this.schName = schName;
    }

    public String getSchName() 
    {
        return schName;
    }
    public void setSchType(String schType) 
    {
        this.schType = schType;
    }

    public String getSchType() 
    {
        return schType;
    }
    public void setSchCode(String schCode) 
    {
        this.schCode = schCode;
    }

    public String getSchCode() 
    {
        return schCode;
    }
    public void setRegion(String region) 
    {
        this.region = region;
    }

    public String getRegion() 
    {
        return region;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setLinkName(String linkName) 
    {
        this.linkName = linkName;
    }

    public String getLinkName() 
    {
        return linkName;
    }
    public void setLinkPhone(String linkPhone) 
    {
        this.linkPhone = linkPhone;
    }

    public String getLinkPhone() 
    {
        return linkPhone;
    }
    public void setSchProfile(String schProfile) 
    {
        this.schProfile = schProfile;
    }

    public String getSchProfile() 
    {
        return schProfile;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("schId", getSchId())
            .append("schName", getSchName())
            .append("schType", getSchType())
            .append("schCode", getSchCode())
            .append("region", getRegion())
            .append("address", getAddress())
            .append("linkName", getLinkName())
            .append("linkPhone", getLinkPhone())
            .append("schProfile", getSchProfile())
            .toString();
    }
}
