package com.example.crud.modulos.asignatura.servicio;

import com.example.crud.modelos.Alumno;
import com.example.crud.modelos.Asignatura;
import com.example.crud.modelos.Persona;
import com.example.crud.modulos.asignatura.dto.AsignaturaDTO;
import com.example.crud.repositorios.AsignaturaRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AsignaturaServicio {
    @Autowired
    private AsignaturaRepositorio asignaturaRepositorio;

    public List<AsignaturaDTO> obtenerAsignaturas() {

        List<Asignatura> lista = asignaturaRepositorio.findAll();
        return lista.stream().map(AsignaturaDTO::new).collect(Collectors.toList());
    }

    public AsignaturaDTO obtenerAsignaturasPorId(Integer id_asignatura) {
        Optional<Asignatura> asignatura = asignaturaRepositorio.findById(id_asignatura);

        if (asignatura.isPresent()) {
            return new AsignaturaDTO(asignatura.get().getId_asignatura(), asignatura.get().getNombre(), asignatura.get().getDescripcion());
        }

        return null;
    }

    public Boolean guardarAsignatura(AsignaturaDTO parametros) {

        Asignatura asignatura = new Asignatura();

        if (parametros.getId_asignatura() != null) {
            asignatura = asignaturaRepositorio.getOne(parametros.getId_asignatura());
        }

        asignatura.setId_asignatura(parametros.getId_asignatura());
        asignatura.setNombre(parametros.getNombre());
        asignatura.setDescripcion(parametros.getDescripcion());
        asignatura.setAlumno(new Alumno(parametros.getAlumno()));

        asignaturaRepositorio.save(asignatura);
        return true;
    }

    public Boolean actualizarAsignatura(AsignaturaDTO parametros) {

        Asignatura asignatura = asignaturaRepositorio.getOne(parametros.getId_asignatura());
        asignatura.setNombre(parametros.getNombre());
        asignatura.setDescripcion(parametros.getDescripcion());
        asignatura.setAlumno(new Alumno(parametros.getAlumno()));

        asignaturaRepositorio.save(asignatura);
        return true;
    }

    public Boolean eliminarAsignatura(Integer id_asignatura) {
        Asignatura asignatura = asignaturaRepositorio.getOne(id_asignatura);

        asignaturaRepositorio.delete(asignatura);
        return true;
    }

    public Boolean activarInactivarAsignatura(Integer id_asignatura) {
        Asignatura asignatura = asignaturaRepositorio.getOne(id_asignatura);
        asignaturaRepositorio.save(asignatura);
        return true;
    }

}
