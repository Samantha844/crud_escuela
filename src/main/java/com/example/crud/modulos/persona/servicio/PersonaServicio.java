package com.example.crud.modulos.persona.servicio;

import com.example.crud.modelos.Alumno;
import com.example.crud.modelos.Persona;
import com.example.crud.modulos.persona.dto.PersonaDTO;
import com.example.crud.repositorios.PersonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonaServicio {
    @Autowired
    private PersonaRepositorio personaRepositorio;

    public List<PersonaDTO> obtenerPersona(){

        List<Persona> lista = personaRepositorio.findAll();
        return  lista.stream().map(PersonaDTO::new).collect(Collectors.toList());
    }

    public PersonaDTO obtenerPersonaPorId(Integer id_persona){
        Optional<Persona> persona = personaRepositorio.findById(id_persona);

        if (persona.isPresent()){
            return new PersonaDTO(
                    persona.get().getNombre(),
                    persona.get().getApellido_paterno(),
                    persona.get().getApellido_materno(),
                    persona.get().getGenero(),
                    persona.get().getCurp(),
                    persona.get().getDireccion(),
                    persona.get().getTelefono(),
                    persona.get().getCorreo()
            );
        }

        return null;
    }

    public Boolean guardarPersona(PersonaDTO parametros) {

        Persona persona = new Persona();

        if (parametros.getId_persona() != null){
            persona = personaRepositorio.getOne(parametros.getId_persona());
        }

        persona.setNombre(parametros.getNombre());
        persona.setApellido_paterno(parametros.getApellido_paterno());
        persona.setApellido_materno(parametros.getApellido_materno());
        persona.setGenero(parametros.getGenero());
        persona.setCurp(parametros.getCurp());
        persona.setDireccion(parametros.getDireccion());
        persona.setTelefono(parametros.getTelefono());
        persona.setCorreo(parametros.getCorreo());

        personaRepositorio.save(persona);
        return true;
    }

    public Boolean actualizarPersona(PersonaDTO parametros) {

        Persona persona = personaRepositorio.getOne(parametros.getId_persona());
        persona.setNombre(parametros.getNombre());
        persona.setApellido_paterno(parametros.getApellido_paterno());
        persona.setApellido_materno(parametros.getApellido_materno());
        persona.setGenero(parametros.getGenero());
        persona.setCurp(parametros.getCurp());
        persona.setDireccion(parametros.getDireccion());
        persona.setTelefono(parametros.getTelefono());
        persona.setCorreo(parametros.getCorreo());

        personaRepositorio.save(persona);
        return true;
    }

    public Boolean eliminarPersona(Integer id_persona) {
        Persona persona = personaRepositorio.getOne(id_persona);

        personaRepositorio.delete(persona);
        return true;
    }

    public Boolean activarInactivarPersona(Integer id_persona) {
        Persona persona = personaRepositorio.getOne(id_persona);
        personaRepositorio.save(persona);
        return true;
    }

}
