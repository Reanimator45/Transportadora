package com.example.transportadora.entidades;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Zona")
public class Zona {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="ubicacion",nullable = false, length =50 )
    private String ubicacion;


    @OneToMany(mappedBy = "zona")
    private List<Mercancia> mercancia;

    @Transient/*se utiliza para indicarle a JPA que un atributo de una Entidad no debe de ser persistente*/
    private String mensajeError;



    public Zona() {
    }

    public Zona(Integer id, String ubicacion, List<Mercancia> mercancia, String mensajeError) {
        this.id = id;
        this.ubicacion = ubicacion;
        this.mercancia = mercancia;
        this.mensajeError = mensajeError;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public List<Mercancia> getMercancia() {
        return mercancia;
    }

    public void setMercancia(List<Mercancia> mercancia) {
        this.mercancia = mercancia;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }
}