package com.uustop.project.system.student.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class StudentMenu {


    public Integer getStuID() {
        return stuID;
    }

    public void setStuID(Integer stuID) {
        this.stuID = stuID;
    }

    private Integer stuID;



    /**
     * 菜单ID
     */
    private Long menuId;

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("studentID", getStuID())
                .append("menuId", getMenuId())
                .toString();
    }
}
