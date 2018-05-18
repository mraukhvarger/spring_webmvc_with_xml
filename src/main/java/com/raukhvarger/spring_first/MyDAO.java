package com.raukhvarger.spring_first;

import com.raukhvarger.spring_first.entities.IEntity;
import com.raukhvarger.spring_first.entities.MyEntity;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class MyDAO {

    @PersistenceContext
    private EntityManager em;

    public void persist(IEntity myEntity) {
        em.persist(myEntity);
    }

    public List<MyEntity> findAll() {
        return em.createQuery("SELECT p FROM MyEntity p").getResultList();
    }
}
