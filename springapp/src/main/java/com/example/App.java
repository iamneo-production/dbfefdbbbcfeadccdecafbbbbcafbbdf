package com.example.springapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        ChildBean childBean = context.getBean(ChildBean.class);
        childBean.displayMessage();

        ((AnnotationConfigApplicationContext) context).close();
    }
}