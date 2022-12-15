package demo.proxy;

import com.llkj.retire.manage.mapper.Permission;
import com.llkj.retire.manage.mapper.Permission2Mapper;
import com.llkj.retire.manage.mapper.PermissionMapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * ProxyTest
 * 责任人:  Chuck
 * 修改人： Chuck
 * 创建/修改时间: 2020/11/19 11:47
 * Copyright :  版权所有
 **/
public class ProxyTest {

    public static void main(String[] args) {

        try {

            //手写代理，模拟mybatis的操作，demo.proxy.SqlSession是我自己写的类。他的getmapper方法返回一个动态代理对象。实际的方法执行类里需要sqlsession
            Permission2Mapper mapper = (Permission2Mapper) demo.proxy.SqlSession.getMapper(Permission2Mapper.class);

            //调用这个，实际会走代理类的demo.proxy.MapperProxy.invoke
            List<Permission> permission = mapper.queryPermissionByParentId("1100");

            System.out.println("permission = [" + permission + "]");




        } catch ( Exception exc) {
            //com.mysql.jdbc.Driver A;
            System.out.println("异常 = [" + exc + "]");
        }

    }
}
