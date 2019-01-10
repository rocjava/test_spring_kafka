package com.penn.springkafka.controller;

import java.io.Serializable;

public class App implements Serializable{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String sayHello(){
        System.out.println("hello "+ name);
        return "hello "+ name;
    }
}
