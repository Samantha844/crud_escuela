package com.example.crud.modulos.colegiatura.servicio;

import com.example.crud.modelos.Alumno;
import com.example.crud.modelos.Asignatura;
import com.example.crud.modelos.Calificacion;
import com.example.crud.modelos.Colegiatura;
import com.example.crud.modulos.calificacion.dto.CalificacionDTO;
import com.example.crud.modulos.colegiatura.dto.ColegiaturaDTO;
import com.example.crud.repositorios.ColegiaturaRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ColegiaturaServicio {
   @Autowired
   private ColegiaturaRepositorio colegiaturaRepositorio;

   public List<ColegiaturaDTO> obtenerColegiaturas(){

        List<Colegiatura> lista = colegiaturaRepositorio.findAll();
        return  lista.stream().map(ColegiaturaDTO::new).collect(Collectors.toList());
    }

    public ColegiaturaDTO obtenerColegiaturasPorId(Integer id_colegiatura){
       Optional<Colegiatura> colegiatura = colegiaturaRepositorio.findById(id_colegiatura);

        if (colegiatura.isPresent()){
            return new ColegiaturaDTO(
                    colegiatura.get().getId_colegiatura(),
                    colegiatura.get().getMonto(),
                    colegiatura.get().getMes(),
                    colegiatura.get().getPagado());
       }

        return null;
    }

    public Boolean guardarColegiatura(ColegiaturaDTO parametros) {

        Colegiatura colegiatura = new Colegiatura();

        if (parametros.getId_colegiatura() != null){
            colegiatura = colegiaturaRepositorio.getOne(parametros.getId_colegiatura());
        }

        colegiatura.setMonto(parametros.getMonto());
        colegiatura.setMes(parametros.getMes());
        colegiatura.setMes(parametros.getMes());
        colegiatura.setPagado(parametros.getPagado());
        colegiatura.setAlumno(new Alumno(parametros.getAlumno()));

        colegiaturaRepositorio.save(colegiatura);
        return true;
    }

    public Boolean actualizarColegiatura(ColegiaturaDTO parametros) {

        Colegiatura colegiatura = colegiaturaRepositorio.getOne(parametros.getId_colegiatura());
        colegiatura.setMonto(parametros.getMonto());
        colegiatura.setMes(parametros.getMes());
        colegiatura.setMes(parametros.getMes());
        colegiatura.setPagado(parametros.getPagado());
        colegiatura.setAlumno(new Alumno(parametros.getAlumno()));

        colegiaturaRepositorio.save(colegiatura);
        return true;
    }

    public Boolean eliminarColegiatura(Integer id_colegiatura) {
        Colegiatura colegiatura = colegiaturaRepositorio.getOne(id_colegiatura);

        colegiaturaRepositorio.delete(colegiatura);
        return true;
    }

    public Boolean activarInactivarColegiatura(Integer id_colegiatura) {
        Colegiatura colegiatura = colegiaturaRepositorio.getOne(id_colegiatura);

        colegiaturaRepositorio.save(colegiatura);
        return true;
    }
}
