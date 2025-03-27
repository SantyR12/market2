package com.example.market;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepositorty extends JpaRepository<Producto, Long> {
    //opcionales
}
