package com.demo.api.repository;

import com.demo.api.model.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface VueloRepository extends JpaRepository<Vuelo, Long> {

    List<Vuelo> findByDestino(String destino);

    List<Vuelo> findByOrigen(String origen);

    // Encuentra vuelos en una fecha específica (puede requerir ajustes en función del formato de fecha)
    List<Vuelo> findByFecha(Date fecha);

    // Encuentra el número de vuelos a un destino específico
    @Query("SELECT COUNT(v) FROM Vuelo v WHERE v.destino = :destino")
    Long countByDestino(String destino);

    // Encuentra el número de vuelos por día
    @Query("SELECT COUNT(v) FROM Vuelo v WHERE FUNCTION('DATE', v.fecha) = FUNCTION('DATE', :fecha)")
    Long countByFecha(Date fecha);

    // Encuentra el número de vuelos por mes
    @Query("SELECT COUNT(v) FROM Vuelo v WHERE FUNCTION('YEAR', v.fecha) = FUNCTION('YEAR', :fecha) AND FUNCTION('MONTH', v.fecha) = FUNCTION('MONTH', :fecha)")
    Long countByMonth(Date fecha);

    // Encuentra el número de vuelos por año
    @Query("SELECT COUNT(v) FROM Vuelo v WHERE FUNCTION('YEAR', v.fecha) = :year")
    Long countByYear(Integer year);
}