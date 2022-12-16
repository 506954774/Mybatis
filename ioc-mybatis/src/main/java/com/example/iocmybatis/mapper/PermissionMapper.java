package com.example.iocmybatis.mapper;



import com.example.iocmybatis.model.Permission;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
xml配置方式
 */
public interface PermissionMapper {

    /**
     * 根据父级id查询菜单集合
     * @param parentId
     * @return
     */
    List<Permission> queryPermissionByParentId(@Param("parentId") String parentId);
}
