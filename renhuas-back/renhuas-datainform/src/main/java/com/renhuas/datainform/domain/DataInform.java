package com.renhuas.datainform.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.renhuas.common.annotation.Excel;
import com.renhuas.common.core.domain.BaseEntity;

/**
 * 数据管理对象 data_inform
 * 
 * @author chenzr
 * @date 2021-11-04
 */
public class DataInform extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long inforId;

    /** 文件名称 */
    @Excel(name = "文件名称")
    private String inforName;

    /** 学年学期 */
    @Excel(name = "学年学期")
    private String schSemester;

    /** 学业阶段 */
    @Excel(name = "学业阶段")
    private String academic;

    /** 文件类型 */
    @Excel(name = "文件类型")
    private String inforType;

    /** 上传时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "上传时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date uploadTime;

    /** 用户ID */
    private Long userId;

    /** 创建人 */
    @Excel(name = "创建人")
    private String username;

    /** 上传状态 */
    @Excel(name = "上传状态")
    private String uploadState;

    /** 锁定状态 */
    @Excel(name = "锁定状态")
    private String lockState;

    public void setInforId(Long inforId) 
    {
        this.inforId = inforId;
    }

    public Long getInforId() 
    {
        return inforId;
    }
    public void setInforName(String inforName) 
    {
        this.inforName = inforName;
    }

    public String getInforName() 
    {
        return inforName;
    }
    public void setSchSemester(String schSemester) 
    {
        this.schSemester = schSemester;
    }

    public String getSchSemester() 
    {
        return schSemester;
    }
    public void setAcademic(String academic) 
    {
        this.academic = academic;
    }

    public String getAcademic() 
    {
        return academic;
    }
    public void setInforType(String inforType) 
    {
        this.inforType = inforType;
    }

    public String getInforType() 
    {
        return inforType;
    }
    public void setUploadTime(Date uploadTime) 
    {
        this.uploadTime = uploadTime;
    }

    public Date getUploadTime() 
    {
        return uploadTime;
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
    public void setUploadState(String uploadState) 
    {
        this.uploadState = uploadState;
    }

    public String getUploadState() 
    {
        return uploadState;
    }
    public void setLockState(String lockState) 
    {
        this.lockState = lockState;
    }

    public String getLockState() 
    {
        return lockState;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("inforId", getInforId())
            .append("inforName", getInforName())
            .append("schSemester", getSchSemester())
            .append("academic", getAcademic())
            .append("inforType", getInforType())
            .append("uploadTime", getUploadTime())
            .append("userId", getUserId())
            .append("username", getUsername())
            .append("uploadState", getUploadState())
            .append("lockState", getLockState())
            .toString();
    }
}
