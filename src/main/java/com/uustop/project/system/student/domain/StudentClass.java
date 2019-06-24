package com.uustop.project.system.student.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class StudentClass {

    private int stuId;
    private int classId;

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    @Override
    public String toString(){
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("stuId",getStuId())
                .append("classId",getClassId())
                .toString();
    }
}
