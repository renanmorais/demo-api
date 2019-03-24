package com.demo.api.model;

import com.flytecnologia.core.model.FlyEntity;
import com.flytecnologia.core.user.FlyUser;
import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
@Audited
public class User extends FlyEntity implements FlyUser {

    @NotNull
    @Size(min = 2, max = 150)
    @Column(name = "username", length = 150, unique = true, nullable = false)
    private String username;

    @NotNull
    @Size(min = 2, max = 150)
    @Column(name = "login", length = 150, unique = true, nullable = false)
    private String login;

    @NotNull
    @Size(min = 2, max = 150)
    @Column(name = "password", length = 150, unique = true, nullable = false)
    private String password;

    @NotNull
    @Size(min = 2, max = 150)
    @Column(name = "tenant", length = 150, unique = true, nullable = false)
    private String tenant;

    @NotNull
    @Size(min = 2, max = 150)
    @Column(name = "email", length = 150, unique = true, nullable = false)
    private String email;


    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    @Override
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
