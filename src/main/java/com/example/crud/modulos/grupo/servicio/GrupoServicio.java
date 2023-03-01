package com.example.crud.modulos.grupo.servicio;

import com.example.crud.modelos.Alumno;
import com.example.crud.modelos.Docente;
import com.example.crud.modelos.Grado;
import com.example.crud.modelos.Grupo;
import com.example.crud.modulos.grado.dto.GradoDTO;
import com.example.crud.modulos.grupo.dto.GrupoDTO;
import com.example.crud.repositorios.GrupoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GrupoServicio {

    @Autowired
    private GrupoRepositorio grupoRepositorio;

    public List<GrupoDTO> obtenerGrupos(){

        List<Grupo> lista = grupoRepositorio.findAll();
        return  lista.stream().map(GrupoDTO::new).collect(Collectors.toList());
    }

    public GrupoDTO obtenerGruposPorId(Integer id_grupo){
        Optional<Grupo> grupo = grupoRepositorio.findById(id_grupo);

        if (grupo.isPresent()){
            return new GrupoDTO(grupo.get().getId_grupo(),grupo.get().getNombre());
        }

        return null;
    }

    public Boolean guardarGrupo(GrupoDTO parametros) {

        Grupo grupo = new Grupo();

        if (parametros.getId_grupo() != null){
            grupo = grupoRepositorio.getOne(parametros.getId_grupo());
        }

        grupo.setNombre(parametros.getNombre());
        grupo.setDocente(new Docente(parametros.getDocente()));

        grupoRepositorio.save(grupo);
        return true;
    }

    public Boolean actualizarGrupo(GrupoDTO parametros) {

        Grupo grupo = grupoRepositorio.getOne(parametros.getId_grupo());
        grupo.setNombre(parametros.getNombre());
        grupo.setDocente(new Docente(parametros.getDocente()));

        grupoRepositorio.save(grupo);
        return true;
    }

    public Boolean eliminarGrupo(Integer id_grupo) {
        Grupo grupo = grupoRepositorio.getOne(id_grupo);

        grupoRepositorio.delete(grupo);
        return true;
    }

    public Boolean activarInactivarGrupo(Integer id_grupo) {
        Grupo grupo = grupoRepositorio.getOne(id_grupo);
        grupoRepositorio.save(grupo);
        return true;
    }
}
