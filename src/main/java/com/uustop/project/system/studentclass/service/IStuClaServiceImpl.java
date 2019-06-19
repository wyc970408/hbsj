package com.uustop.project.system.studentclass.service;

import com.uustop.common.constant.UserConstants;
import com.uustop.common.utils.StringUtils;
import com.uustop.framework.aspectj.lang.annotation.DataScope;
import com.uustop.project.system.role.domain.Role;
import com.uustop.project.system.studentclass.domain.StuCla;
import com.uustop.project.system.studentclass.mapper.StuClaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IStuClaServiceImpl implements IStuClaService{
    @Autowired
    private StuClaMapper stuClaMapper;

    /**
     * 查询学生班级信息集合
     * @param stuCla
     * @return
     */
    @Override
    @DataScope(tableAlias="s")
    public List<StuCla>selectStuClaList(StuCla stuCla){return stuClaMapper.selectClaList(stuCla);}

    /**
     * 查询学生班级管理树
     * @return
     */
    @Override
    public List<Map<String,Object>>selectStuClaTree(){
        List<Map<String,Object>>trees=new ArrayList<>();
        List<StuCla> stuClaList=selectStuClaList(new StuCla());
        trees= getTrees(stuClaList,false,null);
        return trees;
    }

    /**
     * 根据角色ID查询部门（数据权限）
     * @param role
     * @return
     */

    @Override
    public List<Map<String,Object>>roleStuClaTreeData(Role role){
        Long roleId =role.getRoleId();
        List<Map<String,Object>>trees=new ArrayList<>();
        List<StuCla>stuClaList=selectStuClaList(new StuCla());
        if(StringUtils.isNotNull(roleId)){
            List<String>roleDeptList=stuClaMapper.selectRoleClaTree(roleId);
            trees= getTrees(stuClaList,true,roleDeptList);
        }
        else {
            trees=getTrees(stuClaList,false,null);
        }
        return trees;
    }

    /**
     * 对象转班级树
     * @param stuClaList
     * @param isCheck
     * @param roleDeptList
     * @return
     */
    public List<Map<String,Object>>getTrees(List<StuCla> stuClaList,boolean isCheck,List<String> roleDeptList)
    {
        List<Map<String,Object>>trees=new ArrayList<>();
        for(StuCla stuCla:stuClaList)
        {
            if (UserConstants.DEPT_NORMAL.equals(stuCla.getStatus()))
            {
                Map<String,Object>stuClaMap=new HashMap<>();
                stuClaMap.put("id",stuCla.getClaId());
                stuClaMap.put("pId",stuCla.getParentId());
                stuClaMap.put("name",stuCla.getClassName());
                if (isCheck){
                    stuClaMap.put("checked",roleDeptList.contains(stuCla.getClaId()+stuCla.getClassName()));
                }else{
                    stuClaMap.put("checked",false);
                }
                trees.add(stuClaMap);
            }
        }return trees;
    }

    /**
     * 查询班级人数
     * @param parentID
     * @return
     */
    @Override
    public int selectStuClaCount(int parentID){
        StuCla stuCla=new StuCla();
        stuCla.setParentId(parentID);
        return stuClaMapper.selectClassCount(stuCla);
    }

    /**
     * 查询部门是否存在用户
     * @param claId
     * @return
     */
    @Override
    public boolean checkStuClaExistUser(int claId){
        int result=stuClaMapper.checkClassExistUser(claId);
        return result>0?true:false;
    }

    @Override
    public int deleteStuClaById(int claId){return stuClaMapper.deleteClaById(claId);}

    @Override
    public int insertStuCla(StuCla stuCla){
        int parentId = stuCla.getParentId();
        StuCla info=stuClaMapper.selectClaById(parentId);

        stuCla.setAncestros(info.getAncestros()+","+stuCla.getParentId());
            return 1;
    }


}
