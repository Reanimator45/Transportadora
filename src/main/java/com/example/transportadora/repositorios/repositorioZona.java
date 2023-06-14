package com.example.transportadora.repositorios;

import com.example.transportadora.entidades.Zona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface repositorioZona extends JpaRepository<Zona,Integer> {
}
