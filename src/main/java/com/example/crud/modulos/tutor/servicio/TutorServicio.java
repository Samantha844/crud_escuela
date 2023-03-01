package com.example.crud.modulos.tutor.servicio;

import com.example.crud.modelos.Alumno;
import com.example.crud.modelos.Persona;
import com.example.crud.modelos.Tutor;
import com.example.crud.modulos.persona.dto.PersonaDTO;
import com.example.crud.modulos.tutor.dto.TutorDTO;
import com.example.crud.repositorios.TutorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TutorServicio {
    @Autowired
    private TutorRepositorio tutorRepositorio;

    public List<TutorDTO> obtenerTutor(){

        List<Tutor> lista = tutorRepositorio.findAll();
        return  lista.stream().map(TutorDTO::new).collect(Collectors.toList());
    }

    public TutorDTO obtenerTutorPorId(Integer id_tutor){
        Optional<Tutor> tutor = tutorRepositorio.findById(id_tutor);

        if (tutor.isPresent()){
            return new TutorDTO(tutor.get().getId_tutor(),tutor.get().getPerfil());
        }

        return null;
    }

    public Boolean guardarTutor(TutorDTO parametros) {

        Tutor tutor = new Tutor();

        if (parametros.getId_tutor() != null){
            tutor = tutorRepositorio.getOne(parametros.getId_tutor());
        }

        tutor.setPerfil(parametros.getPerfil());
        tutor.setAlumno(new Alumno(parametros.getAlumno()));
        tutor.setPersona(new Persona(parametros.getPersona()));

        tutorRepositorio.save(tutor);
        return true;
    }

    public Boolean actualizarTutor(TutorDTO parametros) {

        Tutor tutor = tutorRepositorio.getOne(parametros.getId_tutor());

        tutor.setPerfil(parametros.getPerfil());
        tutor.setAlumno(new Alumno(parametros.getAlumno()));
        tutor.setPersona(new Persona(parametros.getPersona()));

        tutorRepositorio.save(tutor);
        return true;
    }

    public Boolean eliminarTutor(Integer id_tutor) {
        Tutor tutor = tutorRepositorio.getOne(id_tutor);

        tutorRepositorio.delete(tutor);
        return true;
    }

    public Boolean activarInactivarTutor(Integer id_tutor) {
        Tutor tutor = tutorRepositorio.getOne(id_tutor);
        tutorRepositorio.save(tutor);
        return true;
    }
}
