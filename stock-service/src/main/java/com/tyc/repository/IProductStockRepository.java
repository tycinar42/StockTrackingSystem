package com.tyc.repository;

import com.tyc.repository.entity.ProductStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IProductStockRepository extends JpaRepository<ProductStock, Long> {
    Optional<ProductStock> findOptionalByProductId(Long productId);
    List<ProductStock> findByModelContaining(String model);
}
