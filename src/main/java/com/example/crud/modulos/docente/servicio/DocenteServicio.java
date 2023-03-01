package com.example.crud.modulos.docente.servicio;

import com.example.crud.modelos.*;
import com.example.crud.modulos.calificacion.dto.CalificacionDTO;
import com.example.crud.modulos.docente.dto.DocenteDTO;
import com.example.crud.repositorios.DocenteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DocenteServicio {
    @Autowired
    private DocenteRepositorio docenteRepositorio;

    public List<DocenteDTO> obtenerDocentes() {

        List<Docente> lista = docenteRepositorio.findAll();
        return lista.stream().map(DocenteDTO::new).collect(Collectors.toList());
    }

    public DocenteDTO obtenerDocentesPorId(Integer id_docente) {
        Optional<Docente> docente = docenteRepositorio.findById(id_docente);

        if (docente.isPresent()) {
            return new DocenteDTO(docente.get().getId_docente(), docente.get().getRfc());
        }

        return null;
    }

    public Boolean guardarDocente(DocenteDTO parametros) {

        Docente docente = new Docente();

        if (parametros.getId_docente() != null) {
            docente = docenteRepositorio.getOne(parametros.getId_docente());
        }

        docente.setRfc(parametros.getRfc());
        docente.setPersona(new Persona(parametros.getPersona()));
        docente.setGrupo((Set<Grupo>) new Grupo(parametros.getGrupo()));

        docenteRepositorio.save(docente);
        return true;
    }

    public Boolean actualizarDocente(DocenteDTO parametros) {

        Docente docente = docenteRepositorio.getOne(parametros.getId_docente());
        docente.setRfc(parametros.getRfc());
        docente.setPersona(new Persona(parametros.getPersona()));

        docenteRepositorio.save(docente);
        return true;
    }

    public Boolean eliminarDocente(Integer id_docente) {
        Docente docente = docenteRepositorio.getOne(id_docente);

        docenteRepositorio.delete(docente);
        return true;
    }

    public Boolean activarInactivarDocente(Integer id_docente) {
        Docente docente = docenteRepositorio.getOne(id_docente);
        docenteRepositorio.save(docente);
        return true;
    }
}
