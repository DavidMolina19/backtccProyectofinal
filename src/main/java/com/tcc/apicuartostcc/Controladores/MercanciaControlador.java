package com.tcc.apicuartostcc.Controladores;


import com.tcc.apicuartostcc.entidades.Mercancia;
import com.tcc.apicuartostcc.entidades.Zona;
import com.tcc.apicuartostcc.servicios.implementaciones.MercanciaServicioImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/tcc/mercancias")
public class MercanciaControlador {

    @Autowired
    MercanciaServicioImp mercanciaServicio;


    @PostMapping
    public ResponseEntity<?> registrar(@RequestBody Mercancia mercancia){

        try{

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(mercanciaServicio.registrar(mercancia));
        }catch (Exception error){
              String mensaje="{\"error\":\"Error revise: "+error+"\"}"; //
            return  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(mensaje);

        }

    }


    @GetMapping
    public ResponseEntity<?> buscarTodos(){

        try{

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(mercanciaServicio.buscarTodos());
        }catch (Exception error){

            return  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("{mensaje:datos no encontrados}");

        }

    }
    @GetMapping("/{id}")

    public ResponseEntity<?> buscarPorId(@PathVariable Integer id){

        try{

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(mercanciaServicio.buscarPorId(id));


        }catch (Exception error){

            return  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("{mensaje:datos no encontrados}");

        }

    }
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Integer id,@RequestBody Mercancia mercancia){

        try{

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(mercanciaServicio.actualizar(id,mercancia));


        }catch (Exception error){

            return  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("{mensaje: no se pudo actualizar}");

        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id){

        try{

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(mercanciaServicio.borrar(id));


        }catch (Exception error){

            return  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("{mensaje: no se pudo actualizar}");

        }

    }

}
