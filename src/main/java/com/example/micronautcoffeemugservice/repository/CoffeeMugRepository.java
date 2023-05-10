package com.example.micronautcoffeemugservice.repository;

import com.example.micronautcoffeemugservice.domain.CoffeeMug;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface CoffeeMugRepository extends CrudRepository<CoffeeMug, Long> {
}