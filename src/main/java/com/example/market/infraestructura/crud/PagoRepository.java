package com.example.market.infraestructura.crud;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.market.infraestructura.entity.Orden;
import com.example.market.infraestructura.entity.Pago;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Long> {
    List<Pago> findByOrdenId(Long ordenId);
}
