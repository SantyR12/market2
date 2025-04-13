package com.example.market.infraestructura.crud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.market.infraestructura.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

}

