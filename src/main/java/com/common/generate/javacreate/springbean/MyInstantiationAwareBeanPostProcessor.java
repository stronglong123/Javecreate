package com.common.generate.javacreate.springbean;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.lang.Nullable;

/**
 * @author xialei
 * @date 2022/12/27 11:14
 */
public class MyInstantiationAwareBeanPostProcessor
//        implements InstantiationAwareBeanPostProcessor
{

//    @Override
//    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
//        System.out.println("postProcessBeforeInstantiation被调用，在对象实例化之前调用,beanName=" + beanName);
//        return null;
//    }
//
//    @Override
//    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
//        System.out.println("postProcessAfterInstantiation被调用，beanName=" + beanName);
//        return true;
//    }
//
//    @Override
//    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
//        System.out.println("postProcessProperties被调用，beanName=" + beanName);
//
//        return null;
//    }
//
//
//    public static void main(String[] args) {
//        GenericApplicationContext context = new GenericApplicationContext();
//        context.registerBean("myInstantiationAwareBeanPostProcessor", MyInstantiationAwareBeanPostProcessor.class);
//        context.registerBean("bean1", Bean1.class);
//        context.refresh();
//        System.out.println(context.getBean("bean1"));
//    }
//
//
//    static class Bean1{
//        public void foo(){
//            System.out.println("foo!");
//        }
//
//    }
}
