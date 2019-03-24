package com.demo.api.business.user;

import com.demo.api.business.user.helper.UserFilter;
import com.flytecnologia.core.base.FlyRepositorySearch;

import java.util.Optional;

public interface UserRepositoryQuery extends FlyRepositorySearch<UserFilter> {
    Optional<String> getUser(Long id);
}
