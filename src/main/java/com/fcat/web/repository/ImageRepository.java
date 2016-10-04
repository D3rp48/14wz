package com.fcat.web.repository;

import com.fcat.data.model.Image;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "image", path = "crud/images")
public interface ImageRepository extends CrudRepository<Image, Integer> {
}
