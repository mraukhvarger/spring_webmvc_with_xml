package com.raukhvarger.spring_first;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static java.lang.System.out;

public class Main {

    @Autowired
    MyBean obj;

    public static void main(String[] args) {
//        new Main().simpleBeanExample();
        new Main().autowiredBeanExample();

    }

    void simpleBeanExample() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "spring.xml");

        MyBean obj = (MyBean) context.getBean("myBean");
        out.println(obj.getValue());
    }

    void autowiredBeanExample() {
        out.println(obj.getValue());
    }
}
