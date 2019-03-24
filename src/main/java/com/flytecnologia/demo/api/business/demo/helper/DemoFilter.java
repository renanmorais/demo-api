package com.demo.api.business.demo.helper;


import com.flytecnologia.core.search.FlyFilter;
import com.flytecnologia.core.search.FlyFilterImpl;

public class DemoFilter extends FlyFilterImpl implements FlyFilter {
    private String demo;

    public String getDemo() {
        return demo;
    }

    public void setDemo(String demo) {
        this.demo = demo;
    }
}
