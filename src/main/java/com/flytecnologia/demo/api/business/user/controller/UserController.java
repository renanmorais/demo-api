package com.demo.api.business.user.controller;

import com.flytecnologia.core.base.FlyController;
import com.flytecnologia.core.security.FlyRoles;
import com.demo.api.business.user.UserService;
import com.demo.api.business.user.helper.UserFilter;
import com.demo.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "userController")
@FlyRoles(defaultName = "USER")
public class UserController extends FlyController<User, UserFilter> {

    private UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @Override
    public UserService getService() {
        return service;
    }
}
