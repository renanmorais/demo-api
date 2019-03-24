package com.demo.api.business.demo;

import com.flytecnologia.core.base.FlyRepositoryImpl;
import com.flytecnologia.core.search.FlyPageableResult;
import com.demo.api.business.demo.helper.DemoFilter;
import com.demo.api.model.Demo;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class DemoRepositoryImpl extends FlyRepositoryImpl<Demo, DemoFilter>
        implements DemoRepositoryQuery {

    public DemoRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public FlyPageableResult search(DemoFilter filter, Pageable pageable) {
        Map<String, Object> filters = new HashMap<>();

        StringBuilder hql = new StringBuilder()
                .append("select new br.com.demo.api.model.DemoEntity(\n")
                .append("   demo.id,\n")
                .append("   demo.nomeCultura\n")
                .append(")\n");

        StringBuilder hqlFrom = new StringBuilder()
                .append("from \n")
                .append("   Demo demo\n");

        StringBuilder hqlOrderBy = new StringBuilder()
                .append("order by\n");

        if (isEmpty(filter.getSortGridByField())) {
            hqlOrderBy.append("   demo.id desc\n");
        } else {
            hqlOrderBy.append("   demo.")
                    .append(filter.getSortGridByField())
                    .append(" ")
                    .append(filter.getTypeSortGridByField());
        }

        return getMapOfResults(pageable, hql, hqlFrom, null, hqlOrderBy, filters, filter);
    }

    @Override
    protected void changeSearchWhere(StringBuilder hqlWhere, Map<String, Object> filters, DemoFilter filter) {
        if (isNotEmpty(filter.getDemo())) {
            filters.put("demo", "%" + filter.getDemo().toLowerCase() + "%");
            hqlWhere.append("and fly_to_ascii(lower(demo.demo)) like fly_to_ascii(:demo) \n");
        }
    }

    @Override
    public Optional<String> getDemo(Long id) {
        if (isEmpty(id))
            return Optional.empty();

        String hql = ""; //"select demo.demo from Demo demo where demo.id = :id";

        return getEntityManager().createQuery(hql, String.class)
                .setParameter("id", id)
                .setMaxResults(1)
                .getResultList().stream().filter(Objects::nonNull).findFirst();
    }
}
