package com.uustop.project.system.role.mapper;

import com.uustop.project.system.role.domain.RoleStuCla;

import java.util.List;

public interface RoleStuClaMapper {

    public int deleteRoleStuClaByRoleId(Long roleId);


    public int deleteRoleStuCla(Long[] ids);


    public int selectCountRoleStuClaByStuClaId(Long deptId);


    public int batchRoleStuCla(List<RoleStuCla> roleStuClas);
}
