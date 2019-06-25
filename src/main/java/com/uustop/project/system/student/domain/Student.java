package com.uustop.project.system.student.domain;

import com.uustop.framework.aspectj.lang.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Student {

    @Excel(name="学生学号")
    private Integer stuId;
    @Excel(name = "学生姓名")
    private String stuName;
    @Excel(name = "班级编号")
    private Integer classId;
    @Excel(name = "班级名称")
    private String className;
    @Excel(name = "学生年龄")
    private String stuAge;
    @Excel(name="学生性别")
    private String stuSex;
    @Excel(name = "电话")
    private String phoneNumber;

    @Excel(name = "学生状态")
    private String status;
    @Excel(name = "是否删除")
    private String delFlag;

    private Long[] menuIds;

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Long[] getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(Long[] menuIds) {
        this.menuIds = menuIds;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }



    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }


    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("stuId", getStuId())
                .append("stuName", getStuName())
                .append("classId", getClassId())
                .append("className", getClassName())
                .append("stuAge", getStuAge())
                .append("stuSex", getStuSex())
                .append("phoneNumber",getPhoneNumber())
                .append("status", getStatus())
                .append("delFlag", getDelFlag())
                .toString();
    }
}
