package com.demo.api.business.demo.controller;

import com.demo.api.business.demo.DemoService;
import com.demo.api.model.Demo;
import com.flytecnologia.core.base.FlyController;
import com.flytecnologia.core.security.FlyRoles;
import com.demo.api.business.demo.helper.DemoFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "demoController")
@FlyRoles(defaultName = "DEMO")
public class DemoController extends FlyController<Demo, DemoFilter> {

    private DemoService service;

    @Autowired
    public DemoController(DemoService service) {
        this.service = service;
    }

    @Override
    public DemoService getService() {
        return service;
    }
}
