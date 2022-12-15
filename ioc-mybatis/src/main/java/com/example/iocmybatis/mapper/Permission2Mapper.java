package com.example.iocmybatis.mapper;



import com.llkj.retire.manage.mapper.Permission;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 注解的方式,配置sql
 */
public interface Permission2Mapper {

    /**
     * 查询账号拥有的权限
     * @param accId
     * @return
     */
    @Select("   SELECT\n" +
            "          name, permission\n" +
            "        FROM\n" +
            "        sys_menu\n" +
            "        WHERE\n" +
            "        parent_id = #{parentId}"  )
    List<Permission> queryPermissionByParentId(@Param("accId") String accId);


}
