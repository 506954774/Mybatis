package com.llkj.retire.manage.mapper;



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
    List<Permission> queryPermissionByParentId(@Param("parentId") String parentId);


}
