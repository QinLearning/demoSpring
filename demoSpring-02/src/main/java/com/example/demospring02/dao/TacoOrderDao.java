package com.example.demospring02.dao;

import com.example.demospring02.entity.TacoOrder;
import org.springframework.stereotype.Repository;

@Repository
public interface TacoOrderDao {
    int deleteByPrimaryKey(String id);

    int insert(TacoOrder record);

    int insertSelective(TacoOrder record);

    TacoOrder selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TacoOrder record);

    int updateByPrimaryKey(TacoOrder record);
}