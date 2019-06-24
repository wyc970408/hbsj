package com.uustop.project.system.role.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class RoleStuCla {
    private int roleId;
    private int stuclaId;



    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getStuclaId() {
        return stuclaId;
    }

    public void setStuclaId(int stuclaId) {
        this.stuclaId = stuclaId;
    }
    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("roleId", getRoleId())
                .append("stuclaId", getStuclaId())
                .toString();
    }
}
