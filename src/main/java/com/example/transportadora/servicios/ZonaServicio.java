package com.example.transportadora.servicios;

import com.example.transportadora.entidades.Zona;
import com.example.transportadora.repositorios.repositorioZona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ZonaServicio implements ServicioBase<Zona>{

    @Autowired
    protected repositorioZona repositorioZona;

    @Override
    @Transactional(readOnly=true)
    public List<Zona> buscarTodos() throws Exception {
        try{

            List<Zona>zonas =repositorioZona.findAll();
            return zonas;
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }

    }


    @Override
    public Zona buscarPorId(Integer id) throws Exception {
        try{
            Optional<Zona> zonaOpcional =repositorioZona.findById(id);
            if(zonaOpcional.isPresent()){
                return zonaOpcional.get();
            }else{
                throw new Exception("Usuario no encontrado");
            }
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Zona registrar(Zona datosARegistrar) throws Exception {
        try{
            Zona zonaGuardado=repositorioZona.save(datosARegistrar);
            return zonaGuardado;
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }


    @Override
    public Zona actualizar(Integer id, Zona datosNuevos) throws Exception {
        return null;
    }

    @Override
    public boolean eliminar(Integer id) throws Exception {
        try{

            Optional<Zona>acudienteOpcional =repositorioZona.findById(id);
            if(acudienteOpcional.isPresent()){
                repositorioZona.deleteById(id);
                return true;
            }else{
                throw new Exception("Usuario no encontrado");
            }

        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
