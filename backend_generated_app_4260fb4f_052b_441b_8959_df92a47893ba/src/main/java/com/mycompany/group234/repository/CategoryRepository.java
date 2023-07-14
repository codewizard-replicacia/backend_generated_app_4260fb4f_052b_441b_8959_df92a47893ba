package com.mycompany.group234.repository;


import com.mycompany.group234.model.Category;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class CategoryRepository extends SimpleJpaRepository<Category, String> {
    private final EntityManager em;
    public CategoryRepository(EntityManager em) {
        super(Category.class, em);
        this.em = em;
    }
    @Override
    public List<Category> findAll() {
        return em.createNativeQuery("Select * from \"generated_app\".\"Category\"", Category.class).getResultList();
    }
}