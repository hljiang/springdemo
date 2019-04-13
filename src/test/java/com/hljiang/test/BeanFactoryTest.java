package com.hljiang.test;

import com.hljiang.spring.bean.MyTestBean;
import com.hljiang.spring.bean.PropertiesConfig;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class BeanFactoryTest {

    @Test
    public void testSimpleLoad(){
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("beanFactoryTest.xml"));
        MyTestBean bean = (MyTestBean) bf.getBean("myTestBean");
        Assert.assertEquals("testStr", bean.getTestStr());
    }

    @Test
    public void testPropertiesLoad(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext_test.xml");
        PropertiesConfig bean = (PropertiesConfig) context.getBean("propertiesConfig");
        System.out.println("testValue:" + bean.getTestValue());
        System.out.println("testValue2ForOverride:" + bean.getTestValue2ForOverride());
        System.out.println("valueNoAnnotate:" + bean.getValueNoAnnotate());
        System.out.println("valueNoAnnotateForDefault:" + bean.getValueNoAnnotateForDefault());
        System.out.println("placeHolders:" + bean.getPlaceHolders());
    }
}
