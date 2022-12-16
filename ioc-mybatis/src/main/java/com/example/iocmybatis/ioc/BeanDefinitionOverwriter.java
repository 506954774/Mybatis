package com.example.iocmybatis.ioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * BeanDefinitionOverwriter
 * 类定义的后置处理器，它的作用是把mapper的bean定义注册到ioc里。类定义相当于类的说明书，ioc后续会按说明书来生产bean
 * 责任人:  Chuck
 * 修改人： Chuck
 * 创建/修改时间: 2021/1/20  14:55
 * Copyright : 2014-2018 深圳令令科技有限公司-版权所有
 **/
@Slf4j
@Component
public class BeanDefinitionOverwriter implements BeanDefinitionRegistryPostProcessor {

    public static BeanDefinitionOverwriter.MybatisMappperType[] mybatisMappers={
            new BeanDefinitionOverwriter.MybatisMappperType("com.example.iocmybatis.mapper.Permission2Mapper",false),
            new BeanDefinitionOverwriter.MybatisMappperType("com.example.iocmybatis.mapper.PermissionMapper",true),
    };



    //此方法会在类定义结束后，调用一次。让开发者能添加bean或者去除bean
    @SneakyThrows
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {

        log.info("==================================postProcessBeanDefinitionRegistry" );


        String [] beanDefinitionNames=beanDefinitionRegistry.getBeanDefinitionNames();

       /* //遍历拿到，模拟先删后加。
        for (String name:beanDefinitionNames){
            if(name.equals("permission2Mapper")){
                log.error("BeanDefinitionOverwriter","遍历得到指定的类定义");
                beanDefinitionRegistry.removeBeanDefinition("permission2Mapper");
            }
        }*/


        for(MybatisMappperType mapper:BeanDefinitionOverwriter.mybatisMappers){
            //下面这个类定义，其实是个无效的类定义，因为它是一个接口，没有实例的接口。我们可以通过类实例化的后置处理器去构建bean的实例，这样就会直接使用我们提供的实例（动态代理），而不是框架的反射
            BeanDefinitionBuilder b= BeanDefinitionBuilder.rootBeanDefinition(Class.forName(mapper.className).getClass());
            String beanName = getBeanNameByClassName(mapper.className);
            log.info("==================================beanName:{}",beanName);
            beanDefinitionRegistry.registerBeanDefinition(beanName,b.getBeanDefinition());//首字母小写
        }

        beanDefinitionNames=beanDefinitionRegistry.getBeanDefinitionNames();
        log.info("BeanDefinitionOverwriter-注入灵魂!!!!");

    }

    public static String getBeanNameByClassName(String name) {
        int index=name.lastIndexOf(".");
        String beanName=name.substring(index+1);
        String first=beanName.substring(0,1).toLowerCase();
        beanName=first+beanName.substring(1);
        return beanName;
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

    }


    public static class MybatisMappperType{
        String className;
        boolean isXmlMapper;

        public MybatisMappperType(String className, boolean isXmlMapper) {
            this.className = className;
            this.isXmlMapper = isXmlMapper;
        }
    }
}
