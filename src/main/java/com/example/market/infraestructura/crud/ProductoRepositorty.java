package com.example.market.infraestructura.crud;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.market.infraestructura.entity.Producto;

public interface ProductoRepositorty extends JpaRepository<Producto, Long> {
    //opcionales
}
