package com.uustop.project.system.studentclass.domain;

import com.uustop.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class StuCla extends BaseEntity {
    private static final long seriaVersionUID=1L;
/**班级ID*/
    private int claId;
    /**学院ID*/
    private int parentId;
    /**祖籍列表*/
    private String ancestros;
    /**班级名称*/
    private String className;
    /**显示顺序*/
    private String orderNum;
    /**状态0正常，1停用*/
    private String status;
    /**删除标志（0代表存在 2代表删除*/
    private String delFlag;

    public static long getSeriaVersionUID() {
        return seriaVersionUID;
    }

    public int getClaId() {
        return claId;
    }

    public void setClaId(int claId) {
        this.claId = claId;
    }

    public String getAncestros() {
        return ancestros;
    }

    public void setAncestros(String ancestros) {
        this.ancestros = ancestros;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public String toString(){
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("claId",getClaId())
                .append("parentId",getParentId())
                .append("ancestors",getAncestros())
                .append("className",getClassName())
                .append("orderNum",getOrderNum())
                .append("status",getStatus())
                .append("delFlag",getDelFlag())
                .toString();
    }
}
