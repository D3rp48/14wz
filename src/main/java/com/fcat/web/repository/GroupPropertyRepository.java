package com.fcat.web.repository;

import com.fcat.data.model.PropertyKey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "groupproperties", path = "groupproperty")
public interface GroupPropertyRepository extends CrudRepository<PropertyKey, Integer> {
}
