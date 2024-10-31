package com.example.demospring02.dao;

import com.example.demospring02.entity.IngredientRef;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRefDao {
    int insert(IngredientRef record);

    int insertSelective(IngredientRef record);
}