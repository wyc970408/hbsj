package com.uustop.project.system.student.mapper;

import com.uustop.project.system.student.domain.StudentClass;

import java.util.List;

public interface StudentClassMapper {

    public int deleteStudentClassByStudentId(int studentId);

    public int deleteStudentClass(int[] studentIds);

    public int selectCountStudentClassByClassId(int classId);

    public int batchStudentClass(List<StudentClass> studentClassList);
}
