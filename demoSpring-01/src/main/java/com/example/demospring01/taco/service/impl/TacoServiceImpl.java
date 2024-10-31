package com.example.demospring01.taco.service.impl;
import com.example.demospring01.taco.service.TacoService;
import com.example.demospring02.dao.TacoDao;
import com.example.demospring02.entity.Taco;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @author qin_xf 2024/10/31
 */
@Service("tacoService")
public class TacoServiceImpl implements TacoService {

    /*private final TacoDao tacoRepository;

    public TacoServiceImpl(@Autowired TacoDao tacoRepository) {
        this.tacoRepository = tacoRepository;
    }*/

    @Resource
    private TacoDao tacoRepository;
    @Override
    public void saveTaco(Taco taco) {
        tacoRepository.insert(taco);
    }

    @Override
    public Optional<Taco> findById(String id) {
        return Optional.ofNullable(tacoRepository.selectByPrimaryKey(id));
    }

    @Override
    public PageInfo<Taco> findAllPage() {
        PageHelper.startPage(1, 3);
        List<Taco> list = tacoRepository.findAll();

        PageInfo<Taco> pageInfo = new PageInfo<>(list);

        return pageInfo;
    }

    @Override
    public List<Taco> findAll() {
        PageHelper.startPage(1, 3);
        List<Taco> list = tacoRepository.findAll();

        return list;
    }
}

