package com.tcc.apicuartostcc.servicios.implementaciones;


import com.tcc.apicuartostcc.entidades.Mercancia;
import com.tcc.apicuartostcc.entidades.Zona;
import com.tcc.apicuartostcc.repositorios.Mercanciarepositorio;
import com.tcc.apicuartostcc.repositorios.Zonarepositorio;
import com.tcc.apicuartostcc.servicios.ServicioGenerico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class MercanciaServicioImp implements ServicioGenerico<Mercancia> {
    @Autowired
    Mercanciarepositorio mercanciarepositorio;
    @Autowired
    Zonarepositorio zonaRepositorio;

    @Override
    public List<Mercancia> buscarTodos() throws Exception {
        try{
            List<Mercancia> mercancias=mercanciarepositorio.findAll();
            return mercancias;


        }catch (Exception error ){
            throw new Exception(error.getMessage());

        }
    }

    @Override
    public Mercancia buscarPorId(Integer id) throws Exception {
        try{

            Optional<Mercancia> mercancia =mercanciarepositorio.findById(id);
            return mercancia.get();


        }catch (Exception error ){
            throw new Exception(error.getMessage());

        }
    }

    @Override
    public Mercancia registrar(Mercancia tabla) throws Exception {
        try{

            Optional<Zona> zonaAsociadaAMercancia=zonaRepositorio.findById(tabla.getZona().getId());
            Double capacidadZona=zonaAsociadaAMercancia.get().getDisponible();
            Double capacidadOcupadaMercancia= tabla.getVolumen();
            Double capacidadRestante=capacidadZona-capacidadOcupadaMercancia;

            if (capacidadRestante>=0){// si puedo
                zonaAsociadaAMercancia.get().setDisponible(capacidadRestante);
                zonaRepositorio.save(zonaAsociadaAMercancia.get());
                tabla=mercanciarepositorio.save(tabla);
                return tabla;

            }else{

                throw new Exception("no tenemos capacidad para esta mercancia");
            }






        }catch (Exception error ){
            throw new Exception(error.getMessage());

        }
    }

    @Override
    public Mercancia actualizar(Integer id, Mercancia tabla) throws Exception {
        try{

            Optional<Mercancia> mercanciaBuscada =mercanciarepositorio.findById(id);
            Mercancia mercancia=mercanciaBuscada.get();
            mercancia=mercanciarepositorio.save(tabla);
            return mercancia;


        }catch (Exception error ){
            throw new Exception(error.getMessage());

        }
    }

    @Override
    public Boolean borrar(Integer id) throws Exception {
        try{




            if (mercanciarepositorio.existsById(id)){

                Optional <Mercancia> mercanciaARetirar=mercanciarepositorio.findById(id);
                Optional<Zona> zonaAsociada=zonaRepositorio.findById(mercanciaARetirar.get().getZona().getId());
                Double capacidadOcupadaMercancia=mercanciaARetirar.get().getVolumen();
                Double capacidaDisponibleZona=zonaAsociada.get().getDisponible();
                Double capacidadLiberada=capacidaDisponibleZona+capacidadOcupadaMercancia;

                zonaAsociada.get().setDisponible(capacidadLiberada);
                zonaRepositorio.save(zonaAsociada.get());
                mercanciarepositorio.deleteById(id);

                return true;



            }else{

                throw new Exception();

            }


        }catch (Exception error ){
            throw new Exception(error.getMessage());

        }
    }
}
