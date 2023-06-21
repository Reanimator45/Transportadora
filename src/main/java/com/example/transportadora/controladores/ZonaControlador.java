package com.example.transportadora.controladores;

import com.example.transportadora.entidades.Zona;
import com.example.transportadora.servicios.ZonaServicio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/zona")
@Tag(name="Servicio zona",description =  "Crud zona")
public class ZonaControlador {
    @Autowired
    protected ZonaServicio zonaservicio;
    @PostMapping
    @Operation(summary ="Registrar zona en la BD")
    @ApiResponses(value={
            @ApiResponse(responseCode="201",description = "La zona fue creada conrrectamente"),
            @ApiResponse(responseCode="400",description = "Error al crear la zona")
    })
    public ResponseEntity<Zona> registrar(@RequestBody Zona datosAGuardar){
        try{
            Zona zonaRegistrada = zonaservicio.registrar(datosAGuardar);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(zonaRegistrada);
        }catch (Exception error){
            String mensaje="Error al registrar"+error.getMessage();
            Zona bodegaConError = new Zona();

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(bodegaConError);
        }
    }

    @GetMapping
    public ResponseEntity<List<Zona>>buscarTodos(){
        try{
            List<Zona> zona= zonaservicio.buscarTodos();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(zona);
        }catch(Exception error){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }

    }
    @GetMapping("/{id}")
    public ResponseEntity<Zona>buscarPorId(@PathVariable Integer id ) {
        try {
            Zona zonaEncontrada = zonaservicio.buscarPorId(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(zonaEncontrada);

        }catch(Exception error){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);

        }
    }
}
