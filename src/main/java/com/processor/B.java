package com.processor;

import com.example.BuildProperty;

public class B {

    private String a;

    public String getA() {
        return a;
    }

    @BuildProperty
    public void setA(String a) {
        this.a = a;
    }
}
