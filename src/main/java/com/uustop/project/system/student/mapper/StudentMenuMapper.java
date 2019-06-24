package com.uustop.project.system.student.mapper;

import com.uustop.project.system.student.domain.Student;
import com.uustop.project.system.student.domain.StudentMenu;

import java.util.List;

public interface StudentMenuMapper {

    /**
     * 通过学生ID删除学生和班级
     * @param studentId
     * @return
     */
    public int deleteStudentMenuByStudentId(int studentId);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    public int deleteStudentMenu(Long[] ids);

    /**
     * 查询班级数量
     * @param menuId
     * @return
     */
    public  int selectCountStudentMenuByMenuId(Long menuId);

    /**
     * 批量新增学生班级信息
     * @param studentMenuList
     * @return
     */
    public int batchStudentMenu(List<StudentMenu> studentMenuList);
}
