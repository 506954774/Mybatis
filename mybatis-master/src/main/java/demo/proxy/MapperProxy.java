package demo.proxy;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.executor.loader.ProxyFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * MapperProxy
 * 责任人:  Chuck
 * 修改人： Chuck
 * 创建/修改时间: 2020/11/19 11:53
 * Copyright :  版权所有
 **/
public class MapperProxy implements InvocationHandler {


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Select annotation = method.getAnnotation(Select.class);
        String[] value = annotation.value();
        String sql=value[0];
        String param=args[0].toString();




        ArrayList<Object> list=new ArrayList<>();

        return list;
    }
}
