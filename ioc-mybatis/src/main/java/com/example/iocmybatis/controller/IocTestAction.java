package com.example.iocmybatis.controller;

import com.example.iocmybatis.mapper.Permission2Mapper;
import com.example.iocmybatis.mapper.PermissionMapper;
import com.example.iocmybatis.model.ResponseEntity;
import com.example.iocmybatis.model.Permission;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.annotation.Resource;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


/**
 * Created by chuck on 2019/11/4.
 */
@RestController
@RequestMapping("/ioc")
public class IocTestAction  {

    @Resource
    private Permission2Mapper permission2Mapper;

    @Resource
    private PermissionMapper permissionMapper;

    @ApiOperation(value = "测试spring ioc手动注入mapper，注解形式的mapper", notes = "测试spring ioc手动注入mapper，注解形式的mapper")
    @GetMapping("/test/anotation")
    public ResponseEntity testAnotationMapper() {

        List<Permission> result = permission2Mapper.queryPermissionByParentId("1100");
        ResponseEntity responseEntity= new ResponseEntity<List<Permission>>(true);
        responseEntity.setResult(result);
        return responseEntity;
    }

    @ApiOperation(value = "测试spring ioc手动注入mapper，xml的mapper", notes = "测试spring ioc手动注入mapper，xml的mapper")
    @GetMapping("/test/xml")
    public ResponseEntity testXmlMapper() {

        List<Permission> result = permissionMapper.queryPermissionByParentId("1100");
        ResponseEntity responseEntity= new ResponseEntity<List<Permission>>(true);
        responseEntity.setResult(result);
        return responseEntity;
    }


    @ApiOperation(value = "修改权限名称", notes = "修改权限名称")
    @GetMapping("/test/xml/modify_perm_name")
    public ResponseEntity modifyPermName(
            @ApiParam(name = "permName", value = "新的权限名称", required = true)
            @RequestParam(value = "permName") String permName

    ) {

        permissionMapper.queryPermissionByParentId( "1100");
        ResponseEntity responseEntity= new ResponseEntity<Boolean>(true);
        responseEntity.setResult(true);
        return responseEntity;
    }
}
