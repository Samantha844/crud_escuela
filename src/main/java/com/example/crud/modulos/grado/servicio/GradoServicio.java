package com.example.crud.modulos.grado.servicio;

import com.example.crud.modelos.Alumno;
import com.example.crud.modelos.Colegiatura;
import com.example.crud.modelos.Grado;
import com.example.crud.modelos.Grupo;
import com.example.crud.modulos.colegiatura.dto.ColegiaturaDTO;
import com.example.crud.modulos.grado.dto.GradoDTO;
import com.example.crud.repositorios.ColegiaturaRepositorio;
import com.example.crud.repositorios.GradoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GradoServicio {
    @Autowired
    private GradoRepositorio gradoRepositorio;

    public List<GradoDTO> obtenerGrados(){

        List<Grado> lista = gradoRepositorio.findAll();
        return  lista.stream().map(GradoDTO::new).collect(Collectors.toList());
    }

    public GradoDTO obtenerGradosPorId(Integer id_grado){
        Optional<Grado> grado = gradoRepositorio.findById(id_grado);

        if (grado.isPresent()){
            return new GradoDTO(grado.get().getId_grado(), grado.get().getGrado());
        }

        return null;
    }

    public Boolean guardarGrado(GradoDTO parametros) {

        Grado grado = new Grado();

        if (parametros.getId_grado() != null){
            grado = gradoRepositorio.getOne(parametros.getId_grado());
        }

        grado.setGrado(parametros.getGrado());
        grado.setGrupo(new Grupo(parametros.getGrupo()));
        grado.setAlumno(new Alumno(parametros.getAlumno()));

        gradoRepositorio.save(grado);
        return true;
    }

    public Boolean actualizarGrado(GradoDTO parametros) {

        Grado grado = gradoRepositorio.getOne(parametros.getId_grado());
        grado.setGrado(parametros.getGrado());
        grado.setGrupo(new Grupo(parametros.getGrupo()));
        grado.setAlumno(new Alumno(parametros.getAlumno()));

        gradoRepositorio.save(grado);
        return true;
    }

    public Boolean eliminarGrado(Integer id_grado) {
        Grado grado = gradoRepositorio.getOne(id_grado);

        gradoRepositorio.delete(grado);
        return true;
    }

    public Boolean activarInactivarGrado(Integer id_grado) {
        Grado grado = gradoRepositorio.getOne(id_grado);

        gradoRepositorio.save(grado);
        return true;
    }
}
