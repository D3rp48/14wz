package com.fcat.web.repository;

import com.fcat.data.model.ItemProperty;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "itemproperty", path = "crud/itemproperties")
public interface ItemPropertyRepository extends CrudRepository<ItemProperty, Integer> {
}
