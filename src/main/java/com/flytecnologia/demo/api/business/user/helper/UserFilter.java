package com.demo.api.business.user.helper;

import com.flytecnologia.core.search.FlyFilter;
import com.flytecnologia.core.search.FlyFilterImpl;

public class UserFilter extends FlyFilterImpl implements FlyFilter {
    private String user;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
