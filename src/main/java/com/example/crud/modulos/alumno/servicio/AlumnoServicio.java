package com.example.crud.modulos.alumno.servicio;

import com.example.crud.modelos.Alumno;
import com.example.crud.modelos.Persona;
import com.example.crud.modulos.alumno.dto.AlumnoDTO;
import com.example.crud.repositorios.AlumnoRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlumnoServicio {
    @Autowired
    private AlumnoRepositorio alumnoRepositorio;

    public List<AlumnoDTO> obtenerAlumno(){

        List<Alumno> lista = alumnoRepositorio.findAll();
        return  lista.stream().map(AlumnoDTO::new).collect(Collectors.toList());
    }

    public AlumnoDTO obtenerAlumnoPorId(Integer idAlumno){
        Optional<Alumno> alumno = alumnoRepositorio.findById(idAlumno);

        if (alumno.isPresent()){
            return new AlumnoDTO(alumno.get().getId_alumno(), alumno.get().getMatricula());
        }

        return null;
    }

    public Boolean guardarAlumno(AlumnoDTO parametros) {

        Alumno alumno = new Alumno();

        if (parametros.getId_alumno() != null){
            alumno = alumnoRepositorio.getOne(parametros.getId_alumno());
        }

        alumno.setMatricula(parametros.getMatricula());
        alumno.setPersona(new Persona(parametros.getPersona()));

        alumnoRepositorio.save(alumno);
        return true;
    }

    public Boolean actualizarAlumno(AlumnoDTO parametros) {

        Alumno alumno = alumnoRepositorio.getOne(parametros.getId_alumno());
        alumno.setId_alumno(parametros.getId_alumno());
        alumno.setMatricula(parametros.getMatricula());
        alumno.setPersona(new Persona(parametros.getPersona()));

        alumnoRepositorio.save(alumno);
        return true;
    }

    public Boolean eliminarAlumno(Integer idAlumno) {
        Alumno alumno = alumnoRepositorio.getOne(idAlumno);

        alumnoRepositorio.delete(alumno);
        return true;
    }

    public Boolean activarInactivarAlumno(Integer idAlumno) {
        Alumno alumno = alumnoRepositorio.getOne(idAlumno);
        alumnoRepositorio.save(alumno);
        return true;
    }

}
