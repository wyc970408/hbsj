package com.uustop.project.system.student.service;

import com.uustop.common.support.Convert;
import com.uustop.common.utils.security.ShiroUtils;
import com.uustop.framework.aspectj.lang.annotation.DataScope;
import com.uustop.project.system.student.domain.Student;
import com.uustop.project.system.student.domain.StudentMenu;
import com.uustop.project.system.student.mapper.StudentClassMapper;
import com.uustop.project.system.student.mapper.StudentMapper;
import com.uustop.project.system.student.mapper.StudentMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private StudentMenuMapper studentMenuMapper;
    @Autowired
    private StudentClassMapper studentClassMapper;

    /**
     * 根据分页条件查询学生数据
     *
     * @param student
     * @return
     */
    @Override
    @DataScope(tableAlias = "u")
    public List<Student> selectStudentList(Student student) {
        return studentMapper.selectStudentList(student);
    }

    /**
     * 通过班级查询学生信息
     * @param classId
     * @return
     */
    @Override
    public List<Student>selectStudentByClassId(int classId){
        return selectStudentByClassId(classId);
    }

    /**
     * 查询所有学生信息
     * @return
     */
    @Override
    public List<Student> selectStudentAll() {
        return selectStudentList(new Student());
    }


    /**
     * 通过学号查询学生信息
     * @param studentID
     * @return
     */
    @Override
    public List<Student> selectStudentByID(int studentID) {
        return studentMapper.selectStudentByID(studentID);
    }

    /**
     * 通过学号删除学生信息
     * @param studentID
     * @return
     */
    @Override
    public int deleteStudentByID(int studentID) {
        return studentMapper.deleteStudentByID(studentID);
    }


    /**
     *修改学生信息
     * @param student
     * @return
     */
    @Override
    public int updataStudent(Student student) {
        return studentMapper.updateStudent(student);
    }

    @Override
    public int insertStudent(Student student) {
        studentMapper.insertStudent(student);
        ShiroUtils.clearCachedAuthorizationInfo();
        return insertStudentMenu(student);
    }

    public int insertStudentMenu(Student student) {
        int rows = 1;
        List<StudentMenu> list = new ArrayList<StudentMenu>();
        for (Long menuID : student.getMenuIds()) {
            StudentMenu sm = new StudentMenu();
            sm.setStuId(student.getStuId());
            sm.setMenuId(menuID);
            list.add(sm);
        }
        if (list.size() > 0) {
            rows = studentMenuMapper.batchStudentMenu(list);
        }
        return rows;
    }


}
