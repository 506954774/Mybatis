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
    @Select(" SELECT\n" +
            "          d.Perm_ID permId,\n" +
            "          d.Perm_Parent parentId,\n" +
            "          d.Perm_Name permName,\n" +
            "          d.Perm_Code permCode,\n" +
            "          d.Perm_Resource permResource,\n" +
            "          d.Perm_Route_Name permRouteName,\n" +
            "          d.Perm_Icon permIcon,\n" +
            "          d.Perm_Icon_Sel permIconSel,\n" +
            "          d.Perm_Sort permSort,\n" +
            "          d.Perm_Type permType,\n" +
            "          d.Perm_Status permStatus,\n" +
            "          d.Perm_Anonymous permAnonymous,\n" +
            "          d.Perm_Desc permDesc\n" +
            "        FROM\n" +
            "          pt_account_has_role a\n" +
            "        LEFT JOIN\n" +
            "          pt_role b\n" +
            "        ON\n" +
            "          a.Role_ID = b.Role_ID\n" +
            "        LEFT JOIN\n" +
            "          pt_role_has_permission c\n" +
            "        ON\n" +
            "          b.Role_ID = c.Role_ID\n" +
            "        LEFT JOIN\n" +
            "          (SELECT * FROM pt_permission WHERE Perm_Status = 1) d\n" +
            "        ON\n" +
            "          c.Perm_ID = d.Perm_ID\n" +
            "        WHERE\n" +
            "          d.Perm_Platform = 1\n" +

            "        AND\n" +
            "        a.Acc_ID = #{accId}\n" +
            "        UNION\n" +
            "        SELECT\n" +
            "          f.Perm_ID permId,\n" +
            "          f.Perm_Parent parentId,\n" +
            "          f.Perm_Name permName,\n" +
            "          f.Perm_Code permCode,\n" +
            "          f.Perm_Resource permResource,\n" +
            "          f.Perm_Route_Name permRouteName,\n" +
            "          f.Perm_Icon permIcon,\n" +
            "          f.Perm_Icon_Sel permIconSel,\n" +
            "          f.Perm_Sort permSort,\n" +
            "          f.Perm_Type permType,\n" +
            "          f.Perm_Status permStatus,\n" +
            "          f.Perm_Anonymous permAnonymous,\n" +
            "          f.Perm_Desc permDesc\n" +
            "        FROM\n" +
            "          pt_account_has_permission e\n" +
            "        LEFT JOIN\n" +
            "          (SELECT * FROM pt_permission WHERE Perm_Status = 1) f\n" +
            "        ON\n" +
            "          e.Perm_ID = f.Perm_ID\n" +
            "        WHERE\n" +
            "          f.Perm_Platform = 1\n" +

            "\n" +
            "        AND\n" +
            "        e.Acc_ID = #{accId}\n" +
            "\n" +
            "        ORDER BY\n" +
            "          permSort desc\n" +
            "        limit 1"  )
    List<Permission> queryPermissionInfoByAccId(@Param("accId") String accId);


}
