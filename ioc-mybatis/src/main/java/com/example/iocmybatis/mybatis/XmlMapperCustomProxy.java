package com.example.iocmybatis.mybatis;

import com.llkj.retire.manage.mapper.Permission;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

/**
 * CustomProxy
 * 责任人:  Chuck
 * 修改人： Chuck
 * 创建/修改时间: 2021/1/20  16:01
 * Copyright : 2014-2018 深圳令令科技有限公司-版权所有
 **/
@Slf4j
public class XmlMapperCustomProxy implements InvocationHandler {

    //如果需要什么参数，客户端传过来

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        try {
            String resource = "META-INF/mybatis.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream );

            SqlSession sqlSession=sqlSessionFactory.openSession();

            String className=proxy.getClass().getCanonicalName();
            String methodName=method.getName();
            className =method.getClass().getName();
            className =method.getDeclaringClass().getName();
            Class<?> returnType = method.getReturnType();
            if(returnType ==List.class){

            }

            String call=className+"."+methodName;
            List<Object> result=sqlSession.selectList(call, args[0]);
            return result;

        } catch ( Exception exc) {
            //com.mysql.jdbc.Driver A;
            System.out.println("异常 = [" + exc + "]");

        }


        String param=args[0].toString();
        return "来自动态代理的bean，拼接，返回一个字符串["+param+"]";
    }
}
