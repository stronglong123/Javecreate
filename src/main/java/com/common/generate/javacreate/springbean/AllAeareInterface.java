package com.common.generate.javacreate.springbean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ImportAware;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.weaving.LoadTimeWeaverAware;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.instrument.classloading.LoadTimeWeaver;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;

/**
 * @author xialei
 * @date 2022/12/27 16:17
 */

@Component
public class AllAeareInterface
//        implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware, EnvironmentAware, EmbeddedValueResolverAware,
//        ResourceLoaderAware, ApplicationEventPublisherAware, MessageSourceAware, ApplicationContextAware,
//        ServletContextAware, LoadTimeWeaverAware, ImportAware
{




//    @Override
//    public void setBeanName(String name) {
//        System.out.println("1 BeanNameAware的setBeanName ,name="+ name);
//    }
//
//    @Override
//    public void setBeanClassLoader(ClassLoader classLoader) {
//        System.out.println("2 BeanClassLoaderAware的setBeanClassLoader");
//
//    }
//
//    @Override
//    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
//        System.out.println("3 BeanFactoryAware的setBeanFactory");
//
//    }
//
//
//    @Override
//    public void setEnvironment(Environment environment) {
//        System.out.println("4 EnvironmentAware的setEnvironment");
//
//    }
//
//    @Override
//    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
//        System.out.println("5 EmbeddedValueResolverAware的setEmbeddedValueResolver");
//
//
//    }
//
//    @Override
//    public void setResourceLoader(ResourceLoader resourceLoader) {
//        System.out.println("6 ResourceLoaderAware的setResourceLoader");
//
//    }
//
//
//    @Override
//    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
//        System.out.println("7 ApplicationEventPublisherAware的setApplicationEventPublisher");
//
//    }
//
//    @Override
//    public void setMessageSource(MessageSource messageSource) {
//        System.out.println("8 MessageSourceAware的setMessageSource");
//
//    }
//
//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        System.out.println("9 ApplicationContextAware的setApplicationContext");
//
//    }
//
//
//
//    @Override
//    public void setServletContext(ServletContext servletContext) {
//        System.out.println("10 ServletContextAware的setServletContext");
//
//    }
//
//
//    @Override
//    public void setLoadTimeWeaver(LoadTimeWeaver loadTimeWeaver) {
//        System.out.println("11 LoadTimeWeaverAware的setLoadTimeWeaver");
//
//    }
//
//
//    @Override
//    public void setImportMetadata(AnnotationMetadata annotationMetadata) {
//        System.out.println("12 ImportAware的setImportMetadata");
//    }
//
//    public static void main(String[] args) {
//        GenericApplicationContext context = new GenericApplicationContext();
//        context.registerBean("allAeareInterface", AllAeareInterface.class);
//        context.registerBean("bean1", MyInstantiationAwareBeanPostProcessor.Bean1.class);
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
