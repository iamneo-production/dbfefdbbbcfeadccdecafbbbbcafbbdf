package com.example;

import org.springframework.context.annotation.Bean;

public class MyConfig {
    @Bean(name = "parentBean")
    public MyBean parentBean() {
        MyBean parentBean = new MyBean();
        parentBean.setMessage("Hello from Parent Bean!");
        return parentBean;
    }

    @Bean(name = "childBean")
    public ChildBean childBean() {
        ChildBean childBean = new ChildBean();
        childBean.setParentBean(parentBean());
        return childBean;
    }
}
