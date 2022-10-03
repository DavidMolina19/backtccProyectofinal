package com.tcc.apicuartostcc.Controladores;

import com.tcc.apicuartostcc.entidades.Zona;
import com.tcc.apicuartostcc.servicios.implementaciones.ZonaServicioImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/tcc/zonas")
public class ZonaControlador {
    @Autowired
    ZonaServicioImp zonaServicio;

    @PostMapping
    public ResponseEntity<?> registrar(@RequestBody Zona zona){

        try{

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(zonaServicio.registrar(zona));
        }catch (Exception error){

            return  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("{mensaje:revise su peticion}");

        }

    }

    @GetMapping
    public ResponseEntity<?> buscarTodos(){

        try{

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(zonaServicio.buscarTodos());
        }catch (Exception error){

            return  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("{mensaje:datos no encontrados}");

        }

    }
}
