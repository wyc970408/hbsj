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
     * 通过班级查询学生
     * @param classId
     * @return
     */
    public List<Student> selectStudentByClassID(int classId);

    /**
     * 根据学号查询学生信息
     * @param stuId
     * @return
     */
    public List<Student>selectStudentByID(int stuId);
    /**
     * 根据学号删除用户信息
     * @param studentID 需要删除的ID
     * @return
     */
    public int deleteStudentByID(int studentID);


    /**
     * 批量删除
     * @param ids
     * @return
     */
    public int deleteStudentByIds(int[] ids);
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
