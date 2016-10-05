package com.fcat.web.repository;

import com.fcat.data.model.Image;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "itemsubtype", path = "crud/itemsubtypes")
public interface ItemSubtypeRepository extends CrudRepository<Image, Integer> {
}
