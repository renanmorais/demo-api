package com.demo.api.business.demo;

import com.flytecnologia.core.base.FlyService;
import com.demo.api.business.demo.helper.DemoFilter;
import com.demo.api.model.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DemoService extends FlyService<Demo, DemoFilter> {

    private DemoRepository repository;

    @Autowired
    public DemoService(DemoRepository repository){
        this.repository = repository;
    }

    @Override
    public DemoRepository getRepository() {
        return repository;
    }

    @Override
    protected void beforeSave(Demo entity, Demo oldEntity) {

    }

    public Optional<String> getDemo(Long id){
        return getRepository().getDemo(id);
    }
}
