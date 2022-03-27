package com.interview.price.infrastructure.repository;

import com.interview.price.domain.model.aggregate.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.Optional;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {
  @Query(nativeQuery = true, value = "select * from prices where product_id = (:product) and brand_id = (:brand) and start_date <= (:date) and end_date >= (:date) order by priority desc limit 1")
  /*just to avoid monstrous method name*/
  Optional<Price> findActualPrice(@Param("product") long productId, @Param("brand") long brandId, @Param("date") Instant date);
}
