package com.uustop.project.system.student.controller;

import com.uustop.common.utils.poi.ExcelUtil;
import com.uustop.framework.aspectj.lang.annotation.Log;
import com.uustop.framework.aspectj.lang.enums.BusinessType;
import com.uustop.framework.web.controller.BaseController;
import com.uustop.framework.web.domain.AjaxResult;
import com.uustop.framework.web.page.TableDataInfo;
import com.uustop.project.system.student.domain.Student;
import com.uustop.project.system.student.service.IStudentService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Controller
@RequestMapping("/system/student")
public class StudentController extends BaseController {

    private String prefix = "system/student";

    @Autowired
    private IStudentService studentService;

    @RequiresPermissions("system:student:view")
    @GetMapping()
    public String student(){
        return prefix +"/student";
    }

    @RequiresPermissions("system:student:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Student student){
        startPage();
        List<Student> students= studentService.selectStudentAll();
        return getDataTable(students);
    }

    @Log(title = "学生管理",businessType = BusinessType.EXPORT)
    @RequiresPermissions("system:student:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Student student)
    {
        List<Student> list=studentService.selectStudentList(student);
        ExcelUtil<Student>util=new ExcelUtil<Student>(Student.class);
        return util.exportExcel(list,"student");
    }

    /**
     * 添加学生信息
     * @return
     */
    @GetMapping("/add")
    public String add(){
        return prefix +"/add";
    }


    @RequiresPermissions("system:student:add")
    @Log(title = "学生管理",businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @Transactional(rollbackFor = Exception.class)
    @ResponseBody
    public AjaxResult addSave(Student student)
    {
        return toAjax(studentService.insertStudent(student));
    }

    /**
     * 通过学生ID获取学生信息
     * @param studentID
     * @param mmmap
     * @return
     */
    @GetMapping("/edit/{stuId}")
    public String edit(@PathVariable("stuId") int studentID, ModelMap mmmap)
    {
        mmmap.put("student",studentService.selectStudentByID(studentID));
        return prefix +"/edit";
    }

    /**
     * 修改学生信息
     * @param student
     * @return
     */
    @RequiresPermissions("system:student:edit")
    @Log(title = "学生管理",businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @Transactional(rollbackFor = Exception.class)
    @ResponseBody
    public AjaxResult editSave(Student student){
        return toAjax(studentService.updataStudent(student));
    }

    @RequiresPermissions("system:student:remove")
    @Log(title = "学生管理",businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(int studentId)
    {
        try {
            return toAjax(studentService.deleteStudentByID(studentId));
        }
        catch (Exception e){
            return error(e.getMessage());
        }
    }



}
