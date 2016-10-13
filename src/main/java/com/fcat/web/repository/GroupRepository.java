package com.fcat.web.repository;

import com.fcat.data.model.PropertyKey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "group", path = "crud/groups")
public interface GroupRepository extends CrudRepository<PropertyKey, String> {
}
