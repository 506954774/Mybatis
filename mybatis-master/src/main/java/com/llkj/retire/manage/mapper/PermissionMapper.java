package com.llkj.retire.manage.mapper;



import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
xml配置方式
 */
public interface PermissionMapper {

    /**
     * 查询账号拥有的权限
     * @param accId
     * @return
     */
    List<Permission> queryPermissionInfoByAccId(@Param("accId") String accId);

    /**
     * 查询账号-权限信息
     * @param accId
     * @return
     */
    List<Permission> queryAccHasPermission(String accId);

    /**
     * 查询权限申请订单-权限信息
     * @param orderId
     * @return
     */
    List<Permission> queryOrderHasPermission(String orderId);

    /**
     * 查询账号-权限ID集合
     * @param accId
     * @return
     */
    List<String> queryAccHasPermIds(String accId);

    /**
     * 查询账号角色-权限ID集合
     * @param accId
     * @return
     */
    List<String> queryRoleHasPermIdsByAcc(String accId);

    /**
     * 查询角色-权限ID集合
     * @param roleId
     * @return
     */
    List<String> queryRoleHasPermIds(String roleId);

    /**
     * 查询角色拥有的权限
     * @param roleId
     * @return
     */
    List<Permission> queryPermissionInfoByRoleId(@Param("roleId") String roleId);

    /**
     * 查询申请的权限
     * @param orderId
     * @return
     */
    List<Permission> queryPermissionInfoByOrderId(@Param("orderId") String orderId);

    /**
     * 查询所有权限信息
     * @return
     */
    List<Permission> queryAllPermissionInfo();


    /**
     * 查询权限申请订单-权限ID集合
     * @param orderId
     * @return
     */
    List<String> queryOrderHasPermIds(String orderId);
}
