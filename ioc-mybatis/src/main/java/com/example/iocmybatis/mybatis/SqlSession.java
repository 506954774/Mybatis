package com.example.iocmybatis.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.lang.reflect.Proxy;
import java.util.concurrent.ConcurrentHashMap;

import demo.proxy.MapperProxy;
import lombok.extern.slf4j.Slf4j;

/**
 * SqlSession
 * 责任人:  Chuck
 * 修改人： Chuck
 * 创建/修改时间: 2020/11/19 11:49
 * Copyright :  版权所有
 **/
@Slf4j
public class SqlSession {

    public static Object getMapper(Class clazz) throws Exception{


       // System.out.println("动态代理，返回代理对象");
        log.info("=========================动态代理，返回代理对象[{}]",clazz.getName());


        String resource = "META-INF/mybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        org.apache.ibatis.session.SqlSession sqlSession=sqlSessionFactory.openSession();



        return Proxy.newProxyInstance(SqlSession.class.getClassLoader(),new Class[]{clazz},new MapperProxy(sqlSession,clazz,new ConcurrentHashMap<>()));
    }
}
