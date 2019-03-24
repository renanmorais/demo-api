package com.demo.api.business.demo;

import com.flytecnologia.core.base.FlyRepository;
import com.demo.api.business.demo.helper.DemoFilter;
import com.demo.api.model.Demo;

public interface DemoRepository extends
        DemoRepositoryQuery,
        FlyRepository<Demo, Long, DemoFilter> {

}
