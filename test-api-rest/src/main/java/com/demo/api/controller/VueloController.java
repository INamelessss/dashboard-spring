package com.demo.api.controller;

import com.demo.api.model.Vuelo;
import com.demo.api.repository.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/vuelos")
public class VueloController {

    @Autowired
    private VueloRepository vueloRepository;

    // Obtener todos los vuelos
    @GetMapping
    public List<Vuelo> getAllVuelos() {
        return vueloRepository.findAll();
    }

    // Obtener vuelos por destino
    @GetMapping("/destino/{destino}")
    public List<Vuelo> getVuelosByDestino(@PathVariable String destino) {
        return vueloRepository.findByDestino(destino);
    }

    // Obtener vuelos por origen
    @GetMapping("/origen/{origen}")
    public List<Vuelo> getVuelosByOrigen(@PathVariable String origen) {
        return vueloRepository.findByOrigen(origen);
    }

    // Obtener vuelos por fecha específica
    @GetMapping("/fecha")
    public List<Vuelo> getVuelosByFecha(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fecha) {
        return vueloRepository.findByFecha(fecha);
    }

    // Contar vuelos a un destino específico
    @GetMapping("/conteo/destino/{destino}")
    public Long countVuelosByDestino(@PathVariable String destino) {
        return vueloRepository.countByDestino(destino);
    }

    // Contar vuelos por día
    @GetMapping("/conteo/fecha")
    public Long countVuelosByFecha(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fecha) {
        return vueloRepository.countByFecha(fecha);
    }

    // Contar vuelos por mes
    @GetMapping("/conteo/mes")
    public Long countVuelosByMonth(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fecha) {
        return vueloRepository.countByMonth(fecha);
    }

    // Contar vuelos por año
    @GetMapping("/conteo/ano/{year}")
    public Long countVuelosByYear(@PathVariable int year) {
        return vueloRepository.countByYear(year);
    }
}