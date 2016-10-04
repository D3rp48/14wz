package com.fcat.web.repository;

import com.fcat.data.model.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "item", path = "crud/items")
public interface ItemRepository extends CrudRepository<Item, Integer> {
}
