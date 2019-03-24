package com.demo.api.business.user;

import com.demo.api.business.user.helper.UserFilter;
import com.demo.api.model.User;
import com.flytecnologia.core.base.FlyRepository;

public interface UserRepository extends
        UserRepositoryQuery,
        FlyRepository<User, Long, UserFilter> {

}