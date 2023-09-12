package com.example;

import org.springframework.beans.factory.annotation.Qualifier;

public class ChildBean extends MyBean {
    private MyBean parentBean;

    public MyBean getParentBean() {
        return parentBean;
    }

    public void setParentBean(@Qualifier("parentBean") MyBean parentBean) {
        this.parentBean = parentBean;
    }

    public void displayMessage() {
        System.out.println("Child Bean: " + parentBean.getMessage());
    }

}