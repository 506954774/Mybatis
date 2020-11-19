package demo.proxy;

import java.lang.reflect.Proxy;

/**
 * SqlSession
 * 责任人:  Chuck
 * 修改人： Chuck
 * 创建/修改时间: 2020/11/19 11:49
 * Copyright :  版权所有
 **/
public class SqlSession {

    public static Object getMapper(Class clazz) {
        return Proxy.newProxyInstance(SqlSession.class.getClassLoader(),new Class[]{clazz},new MapperProxy());
    }
}
