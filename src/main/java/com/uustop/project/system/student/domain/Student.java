package com.uustop.project.system.student.domain;

import com.uustop.framework.aspectj.lang.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

public class Student {

    /**
     * 学号
     **/
    @Excel(name = "学号")
    private Integer stuId;
    /**
     * 学生姓名
     **/
    @Excel(name = "姓名")
    private String stuName;

    @Excel(name = "年龄")
    private String stuAge;
    @Excel(name = "性别")
    private String stuSex;
    @Excel(name = "领导")
    private String stuHead;
    @Excel(name = "职务")
    private String stuJob;
    @Excel(name = "身份")
    private String stuRank;
    @Excel(name = "分数")
    private Double stuScroe;
    @Excel(name = "app")
    private Integer stuApp;
    @Excel(name = "appid")
    private Integer appID;
    @Excel(name = "appName")
    private String appName;
    @Excel(name = "年级ID")
    private Integer scId;
    @Excel(name = "年级名称")
    private String scClaname;
    @Excel(name = "状态")
    private Integer status;
    @Excel(name = "删除标志")
    private Integer delFlag;
    @Excel(name = "创建者")
    private String createBy;
    @Excel(name = "创建时间")
    private Date dateTime;
    @Excel(name = "更新人")
    private String updateBy;
    @Excel(name = "更新时间")
    private Date updateTime;

    private Long[] menuIds;

    public Long[] getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(Long[] menuIds) {
        this.menuIds = menuIds;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuAge() {
        return stuAge;
    }

    public void setStuAge(String stuAge) {
        this.stuAge = stuAge;
    }

    public String getStuSex() {
        return stuSex;
    }

    public void setStuSex(String stuSex) {
        this.stuSex = stuSex;
    }

    public String getStuHead() {
        return stuHead;
    }

    public void setStuHead(String stuHead) {
        this.stuHead = stuHead;
    }

    public String getStuJob() {
        return stuJob;
    }

    public void setStuJob(String stuJob) {
        this.stuJob = stuJob;
    }

    public String getStuRank() {
        return stuRank;
    }

    public void setStuRank(String stuRank) {
        this.stuRank = stuRank;
    }

    public Double getStuScroe() {
        return stuScroe;
    }

    public void setStuScroe(Double stuScroe) {
        this.stuScroe = stuScroe;
    }

    public Integer getStuApp() {
        return stuApp;
    }

    public void setStuApp(Integer stuApp) {
        this.stuApp = stuApp;
    }

    public Integer getAppID() {
        return appID;
    }

    public void setAppID(Integer appID) {
        this.appID = appID;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public Integer getScId() {
        return scId;
    }

    public void setScId(Integer scId) {
        this.scId = scId;
    }

    public String getScClaname() {
        return scClaname;
    }

    public void setScClaname(String scClaname) {
        this.scClaname = scClaname;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("stuId", getStuId())
                .append("stuName", getStuName())
                .append("stuAge", getStuAge())
                .append("stuSex", getStuSex())
                .append("stuHead", getStuHead())
                .append("stuJob", getStuJob())
                .append("stuRank", getStuRank())
                .append("stuScroe", getStuScroe())
                .append("stuApp", getStuApp())
                .append("appID", getAppID())
                .append("appName", getAppName())
                .append("scId", getScId())
                .append("scClaname", getScClaname())
                .append("status", getStatus())
                .append("delFlag", getDelFlag())
                .append("createBy", getCreateBy())
                .append("dateTime", getDateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
