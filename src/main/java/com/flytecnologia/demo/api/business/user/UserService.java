package com.demo.api.business.user;

import com.demo.api.business.user.helper.UserFilter;
import com.demo.api.model.User;
import com.flytecnologia.core.base.FlyService;
import com.flytecnologia.core.user.FlyUser;
import com.flytecnologia.core.user.FlyUserPermission;
import com.flytecnologia.core.user.FlyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService extends FlyService<User, UserFilter> implements FlyUserService {

    private UserRepository repository;

    @Autowired
    public UserService(UserRepository repository){
        this.repository = repository;
    }

    @Override
    public UserRepository getRepository() {
        return repository;
    }

    @Override
    protected void beforeSave(User entity, User oldEntity) {

    }

    public Optional<String> getUser(Long id){
        return getRepository().getUser(id);
    }

    @Override
    public String getMessageInvalidLogin() {
        return null;
    }

    @Override
    public Optional<FlyUser> findByLoginOrEmail(String loginOrEmail) {
        return Optional.empty();
    }

    @Override
    public List<FlyUserPermission> getPermissions(String loginOrEmail, String tenant) {
        return null;
    }

    @Override
    public List<String> listAllSchemas() {
        return null;
    }

    @Override
    public Map<String, Object> getAdditionalTokenInformation(Long id) {
        return null;
    }

    @Override
    public void sendNewPassword(String username) {

    }

    @Override
    public void resetPassword(String changePasswordKey, String password, String confirmPassword) {

    }
}
