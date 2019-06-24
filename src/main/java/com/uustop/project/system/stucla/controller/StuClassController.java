package com.uustop.project.system.stucla.controller;

import com.uustop.common.utils.StringUtils;
import com.uustop.framework.aspectj.lang.annotation.Log;
import com.uustop.framework.aspectj.lang.enums.BusinessType;
import com.uustop.framework.web.controller.BaseController;
import com.uustop.framework.web.domain.AjaxResult;
import com.uustop.project.system.role.domain.Role;
import com.uustop.project.system.stucla.domain.StuCla;
import com.uustop.project.system.stucla.service.IStuClaService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/system/stucla")
public class StuClassController extends BaseController {
    private String prefix = "system/stucla";
    @Autowired
    private IStuClaService stuClaService;


    @RequiresPermissions("system:stucla:view")
    @GetMapping()
    public String stucla() {
        return prefix + "/stucla";
    }

    @RequiresPermissions("system:stucla:list")
    @GetMapping("/list")
    @ResponseBody
    public List<StuCla> list(StuCla stuCla) {
        List<StuCla> stuClaList = stuClaService.selectStuClaList(stuCla);
        return stuClaList;
    }


    /**
     * 新增班级
     *
     * @param parentId
     * @param mmap
     * @return
     */
    @GetMapping("/add/{parentId}")
    public String add(@PathVariable("parentId") int parentId, ModelMap mmap) {
        mmap.put("stucla", stuClaService.selectStuClaById(parentId));
        return prefix + "/add";
    }

    /**
     * 新增保存班级
     *
     * @param stuCla
     * @return
     */
    @Log(title = "班级管理", businessType = BusinessType.INSERT)
    @RequiresPermissions("system:stucla:add")
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(StuCla stuCla) {
        return toAjax(stuClaService.insertStuCla(stuCla));
    }

    /**
     * @param claId
     * @param mmap
     * @return
     */
    @GetMapping("/edit/{claId}")
    public String edit(@PathVariable("claId") Integer claId, ModelMap mmap) {
        StuCla stuCla = stuClaService.selectStuClaById(claId);
        if ((StringUtils.isNotNull(stuCla) && 100L == claId)) {
            stuCla.setParentName("无");
        }
        mmap.put("stucla", stuCla);
        return prefix + "/edit";
    }

    /**
     * @param stuCla
     * @return
     */
    @Log(title = "班级管理", businessType = BusinessType.UPDATE)
    @RequiresPermissions("system:stucla:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(StuCla stuCla) {
        return toAjax(stuClaService.updateStuCla(stuCla));
    }

    /**
     * 删除班级
     *
     * @param stuclaId
     * @return
     */
    @Log(title = "班级管理", businessType = BusinessType.DELETE)
    @RequiresPermissions("system:stucla:remove")
    @PostMapping("/remove/{stuclaId}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("stuclaId") int stuclaId) {
        if (stuClaService.selectStuClaCount(stuclaId) > 0) {
            return error(1, "存在下级班级，不允许删除");
        }
        if (stuClaService.checkStuClaExistUser(stuclaId)) {
            return error(1, "班级存在学生，不允许删除");
        }
        return toAjax(stuClaService.deleteStuClaById(stuclaId));
    }

    /**
     * 校验班级名称
     *
     * @param stuCla
     * @return
     */
    @PostMapping("/checkStuClaNameUnique")
    @ResponseBody
    public String checkStuClaNameUnique(StuCla stuCla) {
        return stuClaService.checkStuClaNameUnique(stuCla);
    }

    /**
     * 选择班级树
     *
     * @param stuclaId
     * @param mmap
     * @return
     */
    @GetMapping("/selectStuClaTree/{claId}")
    public String selectStuClaTree(@PathVariable("claId") int stuclaId, ModelMap mmap) {
        mmap.put("stucla", stuClaService.selectStuClaById(stuclaId));
        return prefix + "/tree";
    }

    /**
     * 加载部门树
     *
     * @return
     */

    @GetMapping("treeData")
    @ResponseBody
    public List<Map<String, Object>> treeData() {
        List<Map<String, Object>> tree = stuClaService.selectStuClaTree();
        return tree;
    }

    /**
     * 加载角色部门列表树
     *
     * @param role
     * @return
     */
    @GetMapping("roleStuClaTreeData")
    @ResponseBody
    public List<Map<String, Object>> stuclaTreeData(Role role) {
        List<Map<String, Object>> tree = stuClaService.roleStuClaTreeData(role);
        return tree;
    }
}
