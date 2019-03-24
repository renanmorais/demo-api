package com.demo.api.model;

import com.flytecnologia.core.model.FlyEntity;
import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "demo")
@Audited
public class Demo extends FlyEntity {
    private static final long serialVersionUID = 1L;

    public Demo() {
    }

    public Demo(Long id, String demo) {
        this.setId(id);
        this.demo = demo;
    }

    @NotNull
    @Size(min = 2, max = 150)
    @Column(name = "nome_cultura", length = 150, unique = true, nullable = false)
    private String demo;

    private Number exemplo;

    public String getDemo() {
        return demo;
    }

    public void setDemo(String demo) {
        this.demo = demo;
    }

    public Number getExemplo() {
        return exemplo;
    }

    public void setExemplo(Number exemplo) {
        this.exemplo = exemplo;
    }
}
