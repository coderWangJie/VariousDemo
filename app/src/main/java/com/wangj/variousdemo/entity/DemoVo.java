package com.wangj.variousdemo.entity;

import java.io.Serializable;

public class DemoVo implements Serializable {
    private static final long serialVersionUID = -495718552333758214L;

    private String demoNo;
    private String demoName;

    public DemoVo(String demoNo, String demoName) {
        this.demoNo = demoNo;
        this.demoName = demoName;
    }

    public String getDemoNo() {
        return demoNo;
    }

    public String getDemoName() {
        return demoName;
    }
}
