package com.example.micronautcoffeemugservice.controller;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.HttpStatus;
import com.example.micronautcoffeemugservice.domain.CoffeeMug;
import com.example.micronautcoffeemugservice.repository.CoffeeMugRepository;

@Controller("/coffee-mug")
public class CoffeeMugController {

    private final CoffeeMugRepository coffeeMugRepository;

    public CoffeeMugController(CoffeeMugRepository coffeeMugRepository) {
        this.coffeeMugRepository = coffeeMugRepository;
    }

    @Get("/{id}")
    public CoffeeMug get(Long id) {
        return coffeeMugRepository.findById(id).orElse(null);
    }

    @Post(consumes = MediaType.APPLICATION_JSON)
    public HttpStatus save(@Body CoffeeMug coffeeMug) {
        coffeeMugRepository.save(coffeeMug);
        return HttpStatus.CREATED;
    }
}
