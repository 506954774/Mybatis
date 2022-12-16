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

    //此方法会在每个bean的实例化后执行，有多少bean就执行多少次，此方法允许修改bean的实例
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        log.info("postProcessBeforeInstantiation==================================postProcessBeforeInstantiation" );


        for(BeanDefinitionOverwriter.MybatisMappperType mapper:BeanDefinitionOverwriter.mybatisMappers){

            //匹配到了，就使用动态代理，返回代理对象
            if(beanName.equals(BeanDefinitionOverwriter.getBeanNameByClassName(mapper.className))){
                //直接使用mybatis里面的代理逻辑。他的getmapper方法返回一个动态代理对象。实际的方法执行类里需要sqlsession
                try {
                    return SqlSession.getMapper(Class.forName(mapper.className));
                } catch (Exception e) {

                }

               /* if(mapper.isXmlMapper){
                    //完全可以自己手写代理。代理类会拿到解析到的sql，根据不同类型的sql，执行不同的逻辑：增删改查,然后封装成结果
                    try {
                        return     Proxy.newProxyInstance(
                                BeanInstantionAwearPost.class.getClassLoader(),
                                new Class[] { Class.forName(mapper.className) },
                                new XmlMapperCustomProxy ());
                    } catch (Exception e) {
                    }
                }
                else {
                    //也可以直接使用mybatis里面的代理逻辑（缓存策略等）。他的getmapper方法返回一个动态代理对象。实际的方法执行类里需要sqlsession
                    try {
                        return SqlSession.getMapper(Class.forName(mapper.className));
                    } catch (Exception e) {

                    }
                }*/
            }
        }


        return null;//返回空，则会按类定义去实例化bean
    }
}
