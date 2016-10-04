package com.fcat.web.repository;

import com.fcat.data.model.Component;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "component", path = "crud/components")
public interface ComponentRepository extends CrudRepository<Component, Integer> {
}
