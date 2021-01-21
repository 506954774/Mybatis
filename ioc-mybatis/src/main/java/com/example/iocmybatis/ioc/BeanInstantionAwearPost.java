package com.example.iocmybatis.ioc;

import com.example.iocmybatis.mapper.Permission2Mapper;
import com.example.iocmybatis.mybatis.SqlSession;
import com.example.iocmybatis.mybatis.XmlMapperCustomProxy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Proxy;

import lombok.extern.slf4j.Slf4j;

/**
 * MyInstantionAwearPost
 * 后置处理器，ioc bean实例化的第一个后置处理器
 * 责任人:  Chuck
 * 修改人： Chuck
 * 创建/修改时间: 2021/1/21  10:46
 * Copyright : 2014-2018 深圳令令科技有限公司-版权所有
 **/
@Slf4j
@Configuration
public class BeanInstantionAwearPost implements InstantiationAwareBeanPostProcessor {

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {


        //mybatis先会把这些mapper接口的全路径记录下来，然后批量加入到类定义map里
        BeanDefinitionOverwriter.MybatisMappperType[] mybatisMappers={
                new BeanDefinitionOverwriter.MybatisMappperType("com.example.iocmybatis.mapper.Permission2Mapper",false),
                new BeanDefinitionOverwriter.MybatisMappperType("com.example.iocmybatis.mapper.PermissionMapper",true),
        };


        for(BeanDefinitionOverwriter.MybatisMappperType mapper:mybatisMappers){



            //匹配到了，就使用动态代理，返回代理对象
            if(beanName.equals(BeanDefinitionOverwriter.getBeanNameByClassName(mapper.className))){
                if(mapper.isXmlMapper){
                    //xml,则手写代理。代理类会拿到解析到的sql，然后调用jdbc
                    try {
                        return  Proxy.newProxyInstance(BeanInstantionAwearPost.class.getClassLoader(), new Class[] { Class.forName(mapper.className) },
                                new XmlMapperCustomProxy ());
                    } catch (Exception e) {
                    }
                }
                else {
                    //注解实现的方法，则直接使用mybatis里面的代理逻辑。他的getmapper方法返回一个动态代理对象。实际的方法执行类里需要sqlsession
                    try {
                        return SqlSession.getMapper(Class.forName(mapper.className));
                    } catch (Exception e) {

                    }
                }
            }
        }

       /* if(beanName.equals("permission2Mapper")){
            //手写代理，模拟mybatis的操作，demo.proxy.SqlSession是我自己写的类。他的getmapper方法返回一个动态代理对象。实际的方法执行类里需要sqlsession
            try {
                return SqlSession.getMapper(Permission2Mapper.class);
            } catch (Exception e) {

            }
        }*/

        return null;//返回空，则会按类定义去实例化bean
    }
}
