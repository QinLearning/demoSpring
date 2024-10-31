package com.example.demospring02.dao;

import com.example.demospring02.entity.Taco;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("TacoDao")
public interface TacoDao {
    int deleteByPrimaryKey(String id);

    int insert(Taco record);

    int insertSelective(Taco record);

    Taco selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Taco record);

    int updateByPrimaryKey(Taco record);

    List<Taco> findAll();
}