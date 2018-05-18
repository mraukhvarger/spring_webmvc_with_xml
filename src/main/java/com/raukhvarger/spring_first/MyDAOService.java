package com.raukhvarger.spring_first;

import com.raukhvarger.spring_first.entities.IEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Component
public class MyDAOService {
    @Autowired
    private MyDAO productDao;

    @Transactional
    public void add(IEntity entity) {
        productDao.persist(entity);
    }

    @Transactional
    public void addAll(Collection<? extends IEntity> entities) {
        for (IEntity entity : entities) {
            productDao.persist(entity);
        }
    }

    @Transactional(readOnly = true)
    public List<? extends IEntity> listAll(Class<? extends IEntity> entityClass) {
        return productDao.findAll(entityClass);
    }
}
