package com.fcat.web.repository;

import com.fcat.data.model.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "recipe", path = "crud/recipies")
public interface RecipeRepository extends CrudRepository<Recipe, Integer> {
}
