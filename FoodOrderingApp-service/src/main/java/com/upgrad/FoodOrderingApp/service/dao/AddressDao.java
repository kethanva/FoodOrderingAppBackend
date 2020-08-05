package com.upgrad.FoodOrderingApp.service.dao;

import com.upgrad.FoodOrderingApp.service.entity.AddressEntity;
import com.upgrad.FoodOrderingApp.service.entity.CustomerAddressEntity;
import com.upgrad.FoodOrderingApp.service.entity.CustomerEntity;
import com.upgrad.FoodOrderingApp.service.entity.StateEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class AddressDao {
    @PersistenceContext
    private EntityManager entityManager;
    public AddressEntity saveAddress(AddressEntity addressEntity){
        try {
            entityManager.persist(addressEntity);
        } catch (NoResultException nre) {
            return null;
        }
        return addressEntity;
    }
    public CustomerAddressEntity saveCustomerAddress(CustomerAddressEntity customerAddressEntity){
        try {
            entityManager.persist(customerAddressEntity);
        } catch (NoResultException nre) {
            return null;
        }
        return customerAddressEntity;
    }

    public StateEntity getState(String stateUUID){
        try {
            return entityManager.createNamedQuery("getStateFromUUID", StateEntity.class).setParameter("UUID", stateUUID).getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }
    public List<CustomerAddressEntity> getAllCustomerAddress(CustomerEntity customer) {
        try {
            return entityManager.createNamedQuery("getCustomerAddressList", CustomerAddressEntity.class).setParameter("customer", customer).getResultList();
        } catch (NoResultException nre) {
            return null;
        }
    }

    public CustomerAddressEntity getAddressFromUUID(String addressId){
        try {
            return entityManager.createNamedQuery("getCustomerAddressByUUID", CustomerAddressEntity.class).setParameter("addressId", addressId).getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }
    public AddressEntity deleteAddress(AddressEntity addressEntity){
        try {
            entityManager.remove(addressEntity);
        } catch (NoResultException nre) {
            return null;
        }
        return addressEntity;
    }

    public List<StateEntity> getAllState(){
        try {
            return entityManager.createNamedQuery("getAllState", StateEntity.class).getResultList();
        } catch (NoResultException nre) {
            return null;
        }
    }

}
