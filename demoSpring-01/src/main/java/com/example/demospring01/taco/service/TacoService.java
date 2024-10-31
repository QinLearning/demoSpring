package com.example.demospring01.taco.service;

import com.example.demospring02.entity.Taco;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Optional;

/**
 * @author qin_xf 2024/10/31
 */
public interface TacoService {

    void saveTaco(Taco taco);

    Optional<Taco> findById(String id);

    PageInfo<Taco> findAllPage();

    List<Taco> findAll();
}
