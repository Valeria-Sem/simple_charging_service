package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.CustomerEntity;
import com.netcracker.edu.backend.entity.SubscriptionEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SubscriptionEntityRepository extends CrudRepository<SubscriptionEntity, Integer> {
    List<SubscriptionEntity> getSubscriptionEntitiesByCustomerByIdCustomers(CustomerEntity customer);
}
