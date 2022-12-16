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

    /**
     * @Name:
     * @Description: 注意，此项目并没有依赖mybatis-starter。此permission2Mapper并没有加@Mapper注解，完全是靠手动注入到ioc里面的
     * @Param:
     * @return:
     * @Author: LeiChen
     * @Date:2022/12/16 11:09
     *
     * */
    @ApiOperation(value = "测试spring ioc手动注入mapper，注解形式的mapper", notes = "测试spring ioc手动注入mapper，注解形式的mapper")
    @GetMapping("/test/anotation")
    public ResponseEntity testAnotationMapper() {

        List<Permission> result = permission2Mapper.queryPermissionByParentId("1100");
        ResponseEntity responseEntity= new ResponseEntity<List<Permission>>(true);
        responseEntity.setResult(result);
        return responseEntity;
    }

    /**
     * @Name:
     * @Description: 注意，此项目并没有依赖mybatis-starter。此permissionMapper并没有加@Mapper注解，完全是靠手动注入到ioc里面的
     * @Param:
     * @return:
     * @Author: LeiChen
     * @Date:2022/12/16 11:09
     *
     * */
    @ApiOperation(value = "测试spring ioc手动注入mapper，xml的mapper", notes = "测试spring ioc手动注入mapper，xml的mapper")
    @GetMapping("/test/xml")
    public ResponseEntity testXmlMapper() {

        List<Permission> result = permissionMapper.queryPermissionByParentId("1100");
        ResponseEntity responseEntity= new ResponseEntity<List<Permission>>(true);
        responseEntity.setResult(result);
        return responseEntity;
    }



}
