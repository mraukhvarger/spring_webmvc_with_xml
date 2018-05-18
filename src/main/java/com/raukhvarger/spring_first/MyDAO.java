package com.raukhvarger.spring_first;

import com.raukhvarger.spring_first.entities.IEntity;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Component
public class MyDAO {

    @PersistenceContext
    private EntityManager em;

    public void persist(IEntity myEntity) {
        em.persist(myEntity);
    }

    public List<IEntity> findAll(Class<? extends IEntity > entityClass) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(entityClass);
        Root variableRoot = query.from(entityClass);
        query.select(variableRoot);

        return em.createQuery(query).getResultList();
//        return em.createQuery("SELECT p FROM MyEntity p").getResultList();
    }
}
