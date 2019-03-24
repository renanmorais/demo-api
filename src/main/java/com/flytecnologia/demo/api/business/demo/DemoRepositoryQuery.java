package com.demo.api.business.demo;

import com.flytecnologia.core.base.FlyRepositorySearch;
import com.demo.api.business.demo.helper.DemoFilter;

import java.util.Optional;

public interface DemoRepositoryQuery extends FlyRepositorySearch<DemoFilter> {
    Optional<String> getDemo(Long id);
}
