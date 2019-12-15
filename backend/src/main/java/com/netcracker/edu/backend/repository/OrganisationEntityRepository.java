package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.OrganisationEntity;
import com.netcracker.edu.backend.entity.UsersEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrganisationEntityRepository extends CrudRepository<OrganisationEntity, Integer> {
    OrganisationEntity getOrganisationEntityByUsersByIdUsers(UsersEntity usersEntity);
}
