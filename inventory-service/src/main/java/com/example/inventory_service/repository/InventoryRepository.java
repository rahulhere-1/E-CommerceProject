package com.example.inventory_service.repository;

import com.example.inventory_service.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Long> {

    @Query( value = " FROM Inventory WHERE productCode IN ?1 ")
    List<Inventory> findAllByProductId(List<Integer> productCode);
}
