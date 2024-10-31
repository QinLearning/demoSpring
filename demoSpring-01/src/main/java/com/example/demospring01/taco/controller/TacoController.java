package com.example.demospring01.taco.controller;

import com.example.demospring01.taco.service.TacoService;
import com.example.demospring02.entity.Taco;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping(path="/api/tacos",                      // <1>
                produces="application/json")
//@CrossOrigin(origins="http://tacocloud:8080")        // <2>
public class TacoController {

  @Autowired
  private TacoService tacoService;

  @GetMapping("/recent")
  public Iterable<Taco> recentTacos() {                 //<3>
    return tacoService.findAll();
  }

  @GetMapping("/pageRecent")
  public PageInfo<Taco> pageRecentTacos() {                 //<3>
    return tacoService.findAllPage();
  }

  @PostMapping(consumes="application/json")
  @ResponseStatus(HttpStatus.CREATED)
  public void saveTaco(@RequestBody Taco taco) {
    tacoService.saveTaco(taco);
  }

  @GetMapping("/{id}")
  public Optional<Taco> tacoById(@PathVariable("id") String id) {
    return tacoService.findById(id);
  }

}
