package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.CustomerEntity;
import com.netcracker.edu.backend.entity.SubscriptionEntity;
import org.springframework.data.repository.CrudRepository;

public interface SubscriptionEntityRepository extends CrudRepository<SubscriptionEntity, Integer> {
    SubscriptionEntity[] getSubscriptionEntitiesByCustomerByIdCustomers(CustomerEntity customer);
}
