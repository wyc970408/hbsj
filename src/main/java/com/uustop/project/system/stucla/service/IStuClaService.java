package com.uustop.project.system.stucla.service;
import com.uustop.project.system.role.domain.Role;
import com.uustop.project.system.stucla.domain.StuCla;


import java.util.List;
import java.util.Map;


public interface IStuClaService {
    public List<StuCla>selectStuClaList(StuCla stuCla);

    public List<Map<String,Object>>selectStuClaTree();

    public List<Map<String,Object>>roleStuClaTreeData(Role role);

    public int selectStuClaCount(int parentId);

    public boolean checkStuClaExistUser(int claId);

    public int  deleteStuClaById(int claId);

    public int insertStuCla(StuCla stuCla);

    public int updateStuCla(StuCla stuCla);

    public StuCla selectStuClaById(int claId);

    public String checkStuClaNameUnique(StuCla stuCla);

}
