package com.example.market.infraestructura.crud;

import com.example.market.infraestructura.entity.OrdenItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrdenItem, Long> {
}
