package com.uustop.project.system.student.mapper;

import com.uustop.project.system.student.domain.Student;

import java.util.List;

public interface StudentMapper {
    /**
     * 根据条件分页查询学生数据
     * @param student
     * @return
     */
    public List<Student> selectStudentList(Student student);

    /**
     * 根据查询学生信息
     * @param studentID
     * @return
     */
    public List<Student> selectStudentByID(int studentID);

    /**
     * 根据学号删除用户信息
     * @param studentID 需要删除的ID
     * @return
     */
    public int deleteStudentByID(int studentID);

    /**
     * 更新学生信息
     * @param student
     * @return
     */
    public int updateStudent(Student student);

    /**
     * 新增学生信息
     * @param student
     * @return
     */
    public int insertStudent(Student student);


}
