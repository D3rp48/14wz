package com.fcat.web.repository;

import com.fcat.data.model.ItemType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "itemtype", path = "crud/itemtypes")
public interface ItemTypeRepository extends CrudRepository<ItemType, Integer> {
}
