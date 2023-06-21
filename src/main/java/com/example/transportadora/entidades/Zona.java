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

    @Column(name="ControlEntrada",nullable = false, length =50 )
    private String ControEntrada;

    @Column(name="ControlSalida",nullable = false, length =50 )
    private String ControlSalida;

    @Column(name="Ubicacion",nullable = false, length =50 )
    private String Ubicacion;


    @OneToMany(mappedBy = "bodega")
    private List<Mercancia> mercancia;

    @Transient/*se utiliza para indicarle a JPA que un atributo de una Entidad no debe de ser persistente*/
    private String mensajeError;



    public Zona() {
    }

    public Zona(Integer id, String controEntrada, String controlSalida, String ubicacion, List<Mercancia> mercancia) {
        this.id = id;
        ControEntrada = controEntrada;
        ControlSalida = controlSalida;
        Ubicacion = ubicacion;
        this.mercancia = mercancia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getControEntrada() {
        return ControEntrada;
    }

    public void setControEntrada(String controEntrada) {
        ControEntrada = controEntrada;
    }

    public String getControlSalida() {
        return ControlSalida;
    }

    public void setControlSalida(String controlSalida) {
        ControlSalida = controlSalida;
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        Ubicacion = ubicacion;
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