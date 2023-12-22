package com.demo.api.service;

import com.demo.api.model.Vuelo;
import com.demo.api.repository.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class VueloService {

    private final VueloRepository vueloRepository;

    @Autowired
    public VueloService(VueloRepository vueloRepository) {
        this.vueloRepository = vueloRepository;
    }

    public List<Vuelo> obtenerTodosLosVuelos() {
        return vueloRepository.findAll();
    }

    public List<Vuelo> obtenerVuelosPorDestino(String destino) {
        return vueloRepository.findByDestino(destino);
    }

    public List<Vuelo> obtenerVuelosPorOrigen(String origen) {
        return vueloRepository.findByOrigen(origen);
    }

    public List<Vuelo> obtenerVuelosPorFecha(Date fecha) {
        return vueloRepository.findByFecha(fecha);
    }

    public Long contarVuelosPorDestino(String destino) {
        return vueloRepository.countByDestino(destino);
    }

    public Long contarVuelosPorFecha(Date fecha) {
        return vueloRepository.countByFecha(fecha);
    }

    public Long contarVuelosPorMes(Date fecha) {
        return vueloRepository.countByMonth(fecha);
    }

    public Long contarVuelosPorAno(Integer year) {
        return vueloRepository.countByYear(year);
    }

    // Métodos adicionales para manejar otras lógicas de negocio y transformaciones de datos pueden ser añadidos aquí.
}