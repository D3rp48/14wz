package com.fcat.data.dao.impl;

import com.fcat.data.dao.RecipeDao;
import com.fcat.data.model.Recipe;
import org.springframework.stereotype.Repository;

@Repository
public class RecipeDaoImpl extends GenericDaoImpl<Recipe, Integer> implements RecipeDao {
    public RecipeDaoImpl() {
        super(Recipe.class);
    }
}
