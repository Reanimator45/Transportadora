package com.example.transportadora.entidades;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="mercancia")
public class Mercancia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="volumen")
    private Integer volumen;

    @Column(name="FechaIngreso")
    private Date fechaingreso;

    @Column(name="FechaSalida")
    private Date fechasalida;

public  Mercancia () {
}
    public Mercancia(Integer id, String nombre, Integer volumen, Date fechaingreso, Date fechasalida) {
        this.id = id;
        this.nombre = nombre;
        this.volumen = volumen;
        this.fechaingreso = fechaingreso;
        this.fechasalida = fechasalida;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getvolumen() {
        return volumen;
    }

    public void setvolumen(Integer volumen) {
        this.volumen = volumen;
    }

    public  Date getfechaingreso() { return fechaingreso;}

    public  void  setFechaingreso(Date fechaingreso) {this.fechaingreso = fechaingreso;}

    public  Date getFechasalida() { return fechasalida;}

    public  void  setFechasalida(Date fechasalida) {this.fechasalida = fechasalida;}



}
