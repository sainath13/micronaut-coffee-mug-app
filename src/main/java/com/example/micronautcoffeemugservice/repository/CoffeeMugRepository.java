package com.example.micronautcoffeemugservice.repository;

import com.example.micronautcoffeemugservice.domain.CoffeeMug;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;


@Repository
@Transactional
public interface CoffeeMugRepository extends CrudRepository<CoffeeMug, Long> {

    @Query(
            value = "SELECT * FROM coffee_mug WHERE (:displayName IS NULL OR display_name ILIKE CONCAT('%', :displayName, '%')) " +
                    "AND (:coffeeMugType IS NULL OR coffee_mug_type ILIKE CONCAT('%', :coffeeMugType, '%')) " +
                    "AND (:minPrice IS NULL OR price_in_usd >= :minPrice) " +
                    "AND (:maxPrice IS NULL OR price_in_usd <= :maxPrice)",
            nativeQuery = true
    )
    public List<CoffeeMug> searchCoffeeMugs(@Nullable String displayName, @Nullable String coffeeMugType, @Nullable BigDecimal minPrice, @Nullable BigDecimal maxPrice);
}