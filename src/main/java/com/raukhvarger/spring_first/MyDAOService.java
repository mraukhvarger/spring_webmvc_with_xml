package com.raukhvarger.spring_first;

import com.raukhvarger.spring_first.entities.MyEntity;
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
    public void add(MyEntity myEntity) {
        productDao.persist(myEntity);
    }

    @Transactional
    public void addAll(Collection<MyEntity> myEntities) {
        for (MyEntity myEntity : myEntities) {
            productDao.persist(myEntity);
        }
    }

    @Transactional(readOnly = true)
    public List<MyEntity> listAll() {
        return productDao.findAll();

    }
}
