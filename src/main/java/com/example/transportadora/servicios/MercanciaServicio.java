package com.example.transportadora.servicios;

import com.example.transportadora.entidades.Mercancia;
import com.example.transportadora.repositorios.repositorioMercancia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MercanciaServicio implements ServicioBase<Mercancia>{

    @Autowired
    private repositorioMercancia repositorioMercancia;


    @Override
    @Transactional(readOnly = true)
    public List<Mercancia> buscarTodos() throws Exception{
        try{
            List<Mercancia>mercancias=repositorioMercancia.findAll();
            return mercancias;
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    @Transactional(readOnly=true)
    public Mercancia buscarPorId(Integer id) throws Exception {
        try{
            Optional<Mercancia> mercaciaOpcional=repositorioMercancia.findById(id);
            if(mercaciaOpcional.isPresent()){
                return mercaciaOpcional.get();


            }else{
                throw new Exception("Usuario no encontrado");
            }
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Mercancia registrar(Mercancia datosARegistrar) throws Exception {
        try {
            return repositorioMercancia.save(datosARegistrar);
        }catch(Exception error){
            throw new Exception(error.getMessage());

        }
    }

    @Override
    public Mercancia actualizar(Integer id, Mercancia datosNuevos) throws Exception {
        try{
            Optional<Mercancia>mercanciaOpcional =repositorioMercancia.findById(id);
            if(mercanciaOpcional.isPresent()){
                Mercancia mercanciaExistente=mercanciaOpcional.get();
                mercanciaExistente.setNombre(datosNuevos.getNombre());
                mercanciaExistente.setDescripcion(datosNuevos.getDescripcion());
                mercanciaExistente.setFecha_entrada(datosNuevos.getFecha_entrada());
                mercanciaExistente.setMotivo_devolucion(datosNuevos.getMotivo_devolucion());
                mercanciaExistente.setVolumen(datosNuevos.getVolumen());
                Mercancia mercanciaActualizada=repositorioMercancia.save(mercanciaExistente);
                return mercanciaActualizada;
            }else{
                throw new Exception("Mercancia no encontrada");
            }
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public boolean eliminar(Integer id) throws Exception {
        try{

            Optional<Mercancia>mercanciaOpcional =repositorioMercancia.findById(id);
            if(mercanciaOpcional.isPresent()){
                repositorioMercancia.deleteById(id);
                return true;
            }else{
                throw new Exception("Usuario no encontrado");
            }

        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }
}

