package com.upgrad.FoodOrderingApp.service.dao;

import com.upgrad.FoodOrderingApp.service.entity.CategoryEntity;
import com.upgrad.FoodOrderingApp.service.entity.RestaurantCategoryEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CategoryDao {

    @PersistenceContext
    EntityManager entityManager;
    public List<RestaurantCategoryEntity> getCategoriesByRestaurant(String restaurantUUID){
        try {
            return entityManager.createNamedQuery("getCategoriesByRestaurant", RestaurantCategoryEntity.class).setParameter("restaurantUUID", restaurantUUID).getResultList();
        } catch (NoResultException nre) {
            return null;
        }
    }

}