package com.demo.api.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "vuelos")
public class Vuelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "avion", nullable = false)
    private String avion;

    @Column(name = "destino", nullable = false)
    private String destino;

    @Column(name = "origen", nullable = false)
    private String origen;

    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    // Constructores, getters y setters

    public Vuelo() {
        // Constructor por defecto
    }

    // Constructor con parámetros
    public Vuelo(String avion, String destino, String origen, Date fecha) {
        this.avion = avion;
        this.destino = destino;
        this.origen = origen;
        this.fecha = fecha;
    }

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAvion() {
        return avion;
    }

    public void setAvion(String avion) {
        this.avion = avion;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    // Método toString para representación en cadena de la entidad
    @Override
    public String toString() {
        return "Vuelo{" +
                "id=" + id +
                ", avion='" + avion + '\'' +
                ", destino='" + destino + '\'' +
                ", origen='" + origen + '\'' +
                ", fecha=" + fecha +
                '}';
    }
}