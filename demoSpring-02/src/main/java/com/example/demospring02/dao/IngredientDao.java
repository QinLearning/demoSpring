package com.example.demospring02.dao;

import com.example.demospring02.entity.Ingredient;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientDao {
    int insert(Ingredient record);

    int insertSelective(Ingredient record);
}