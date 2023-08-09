package com.example.micronautcoffeemugservice.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.http.HttpStatus;
import com.example.micronautcoffeemugservice.domain.CoffeeMug;
import com.example.micronautcoffeemugservice.repository.CoffeeMugRepository;
import com.example.common.exceptions.BadRequestException;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

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
    public HttpStatus save(@Valid @Body CoffeeMug coffeeMug) {
        coffeeMugRepository.save(coffeeMug);
        return HttpStatus.CREATED;
    }


    //search api
    @Get(produces = MediaType.APPLICATION_JSON)
    @Transactional
    public List<CoffeeMug> searchCoffeeMugs(
            @QueryValue(value = "displayName", defaultValue = "") String displayName,
            @QueryValue(value = "mugType", defaultValue = "") String coffeeMugType,
            @QueryValue(value = "priceRange", defaultValue = "") String priceRange
    ) {
        if (displayName.isEmpty() && coffeeMugType.isEmpty()
         && priceRange.isEmpty()) {
            throw new BadRequestException("Invalid request. Must pass at least one of displayName, mugType and priceRange");
        }
        BigDecimal minPrice = null;
        BigDecimal maxPrice = null;
        if (!priceRange.isEmpty()) {
            String[] priceValues = priceRange.split("-");
            if (priceValues.length != 2) {
                throw new BadRequestException("Invalid price range format. Must be in the format: min-max");
            }
            try {
                minPrice = new BigDecimal(priceValues[0]);
                maxPrice = new BigDecimal(priceValues[1]);
            } catch (NumberFormatException e) {
                throw new BadRequestException("Invalid price value. Must be a decimal number");
            }
        }

        return coffeeMugRepository.searchCoffeeMugs(displayName, coffeeMugType, minPrice, maxPrice);
        //return coffeeMugRepository.searchCoffeeMugs(displayName, minPrice, maxPrice);
    }


}
