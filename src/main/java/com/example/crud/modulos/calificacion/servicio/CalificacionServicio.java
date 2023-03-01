package com.example.crud.modulos.calificacion.servicio;

import com.example.crud.modelos.Alumno;
import com.example.crud.modelos.Asignatura;
import com.example.crud.modelos.Calificacion;
import com.example.crud.modulos.calificacion.dto.CalificacionDTO;
import com.example.crud.repositorios.CalificacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CalificacionServicio {
    @Autowired
    private CalificacionRepositorio calificacionRepositorio;

    public List<CalificacionDTO> obtenerCalificaciones() {

        List<Calificacion> lista = calificacionRepositorio.findAll();
        return lista.stream().map(CalificacionDTO::new).collect(Collectors.toList());
    }

    public CalificacionDTO obtenerCalificacionesPorId(Integer id_calificacion) {
        Optional<Calificacion> calificacion = calificacionRepositorio.findById(id_calificacion);

        if (calificacion.isPresent()) {
            return new CalificacionDTO(
                    calificacion.get().getId_calificacion(),
                    calificacion.get().getSemestre(),
                    calificacion.get().getMateria());
        }

        return null;
    }

    public Boolean guardarCalificacion(CalificacionDTO parametros) {

        Calificacion calificacion = new Calificacion();

        if (parametros.getId_calificacion() != null) {
            calificacion = calificacionRepositorio.getOne(parametros.getId_calificacion());
        }

        calificacion.setSemestre(parametros.getSemestre());
        calificacion.setMateria(parametros.getMateria());
        calificacion.setAlumno(new Alumno(parametros.getAlumno()));
        calificacion.setAsignatura(new Asignatura(parametros.getAsignatura()));

        calificacionRepositorio.save(calificacion);
        return true;
    }

    public Boolean actualizarCalificacion(CalificacionDTO parametros) {

        Calificacion calificacion = calificacionRepositorio.getOne(parametros.getId_calificacion());
        calificacion.setSemestre(parametros.getSemestre());
        calificacion.setMateria(parametros.getMateria());
        calificacion.setAlumno(new Alumno(parametros.getAlumno()));
        calificacion.setAsignatura(new Asignatura(parametros.getAsignatura()));

        calificacionRepositorio.save(calificacion);
        return true;
    }

    public Boolean eliminarCalificacion(Integer id_calificacion) {
        Calificacion calificacion = calificacionRepositorio.getOne(id_calificacion);

        calificacionRepositorio.delete(calificacion);
        return true;
    }

    public Boolean activarInactivarCalificacion(Integer id_calificacion) {
        Calificacion calificacion = calificacionRepositorio.getOne(id_calificacion);
        calificacionRepositorio.save(calificacion);
        return true;
    }
}
