package com.uustop.project.system.stucla.mapper;

import com.uustop.project.system.stucla.domain.StuCla;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StuClaMapper {
    /**
     * 查询班级人数
     * @param stuCla 班级信息
     * @return
     */

    public int selectClassCount(StuCla stuCla);

    /**
     * 查询班级是否存在学生
     * @param claId
     * @return
     */
    public int checkClassExistUser(int claId);

    /**
     * 查询班级信息
     * @param stuCla
     * @return
     */

    public List<StuCla>selectClaList(StuCla stuCla);

    /**
     * 删除班级信息
     * @param claId
     * @return
     */

    public int deleteClaById(int claId);


    public int insertCla(StuCla stuCla);

    public int updateCla(StuCla stuCla);

    public int updateClaStudent(@Param("clas")List<StuCla> clas);

    public StuCla selectClaById(int claId);

    public StuCla checkClaNameUnique(@Param("className")String className,@Param("parentId")int parentId);

    public List<String> selectRoleClaTree(Long roleId);
}
