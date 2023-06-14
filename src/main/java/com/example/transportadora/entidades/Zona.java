package com.example.transportadora.entidades;

import jakarta.persistence.*;


@Entity
@Table(name="Zona")
public class Zona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="volumen")
    private Integer volumen;


public  Zona() {

}
    public Zona(Integer id, String nombre, Integer volumen) {
        this.id = id;
        this.nombre = nombre;
        this.volumen = volumen;
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

    public void setvolumen(Integer escalafon) {
        this.volumen = volumen;
    }
}