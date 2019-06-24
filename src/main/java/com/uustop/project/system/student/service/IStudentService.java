package com.uustop.project.system.student.service;

import com.uustop.project.system.student.domain.Student;
import java.util.List;

public interface IStudentService {
    /**
     * 根绝条件分页查询学生数据
     * @param student
     * @return
     */
    public List<Student> selectStudentList(Student student);

    /**
     * 根据学生ID查询学生信息
     * @param studentID
     * @return
     */
    public List<Student> selectStudentByID(int studentID);

    /**
     * 通过班级查询学生
     * @param classId
     * @return
     */
    public List<Student>selectStudentByClassId(int classId);
    /**
     * 通过学生ID删除学生
     * @param studentID
     * @return
     */
    public int deleteStudentByID(int studentID);

    /**
     * 更新学生信息
     * @param student
     * @return
     */
    public int updataStudent(Student student);

    /**
     * 添加学生信息
     * @param student
     * @return
     */
    public int insertStudent(Student student);

    public List<Student> selectStudentAll();
}
