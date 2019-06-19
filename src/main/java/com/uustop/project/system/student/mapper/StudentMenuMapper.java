package com.uustop.project.system.student.mapper;

import com.uustop.project.system.student.domain.Student;
import com.uustop.project.system.student.domain.StudentMenu;

import java.util.List;

public interface StudentMenuMapper {
    public int deleteStudentMenuByStudentId(int studentId);
    public int deleteStudentMenu(Long[] ids);
    public  int selectCountStudentMenuByMenuId(Long menuId);
    public int batchStudentMenu(List<StudentMenu> studentMenuList);
}
