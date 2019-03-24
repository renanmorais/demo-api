package com.demo.api.business.user;

import com.demo.api.business.user.helper.UserFilter;
import com.demo.api.model.User;
import com.flytecnologia.core.base.FlyRepositoryImpl;
import com.flytecnologia.core.search.FlyPageableResult;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class UserRepositoryImpl extends FlyRepositoryImpl<User, UserFilter>
        implements UserRepositoryQuery {

    public UserRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public FlyPageableResult search(UserFilter filter, Pageable pageable) {
        Map<String, Object> filters = new HashMap<>();

        StringBuilder hql = new StringBuilder()
                .append("select new br.com.demo.api.model.UserEntity(\n")
                .append("   user.id,\n")
                .append("   user.nome\n")
                .append(")\n");

        StringBuilder hqlFrom = new StringBuilder()
                .append("from \n")
                .append("   User user\n");

        StringBuilder hqlOrderBy = new StringBuilder()
                .append("order by\n");

        if (isEmpty(filter.getSortGridByField())) {
            hqlOrderBy.append("   user.id desc\n");
        } else {
            hqlOrderBy.append("   user.")
                    .append(filter.getSortGridByField())
                    .append(" ")
                    .append(filter.getTypeSortGridByField());
        }

        return getMapOfResults(pageable, hql, hqlFrom, null, hqlOrderBy, filters, filter);
    }

    @Override
    protected void changeSearchWhere(StringBuilder hqlWhere, Map<String, Object> filters, UserFilter filter) {
        if (isNotEmpty(filter.getUser())) {
            filters.put("demo", "%" + filter.getUser().toLowerCase() + "%");
            hqlWhere.append("and fly_to_ascii(lower(demo.demo)) like fly_to_ascii(:demo) \n");
        }
    }

    @Override
    public Optional<String> getUser(Long id) {
        if (isEmpty(id))
            return Optional.empty();

        String hql = ""; //"select demo.demo from Demo demo where demo.id = :id";

        return getEntityManager().createQuery(hql, String.class)
                .setParameter("id", id)
                .setMaxResults(1)
                .getResultList().stream().filter(Objects::nonNull).findFirst();
    }
}
