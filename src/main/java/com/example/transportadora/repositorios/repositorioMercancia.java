package com.example.transportadora.repositorios;


import com.example.transportadora.entidades.Mercancia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface repositorioMercancia extends JpaRepository<Mercancia,Integer>{
}