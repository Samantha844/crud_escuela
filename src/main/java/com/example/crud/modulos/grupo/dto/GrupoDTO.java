package com.example.crud.modulos.grupo.dto;

import com.example.crud.modelos.Docente;
import com.example.crud.modelos.Grado;
import com.example.crud.modelos.Grupo;


public class GrupoDTO {
    private Integer id_grupo;
    private String nombre;
    private Docente docente;
    private Grado grado;

    public GrupoDTO(Integer idGrupo, String nombre) {
        this.id_grupo = idGrupo;
        this.nombre = nombre;
    }
    public GrupoDTO(Grupo grupo) {
        this.id_grupo = grupo.getId_grupo();
        this.nombre = grupo.getNombre();
    }

    public Integer getId_grupo() {return id_grupo;}

    public void setId_grupo(Integer id_grupo) {this.id_grupo = id_grupo;}

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public Docente getDocente() {return docente;}

    public void setDocente(Docente docente) {this.docente = docente;}

    public Grado getGrado() {return grado;}

    public void setGrado(Grado grado) {this.grado = grado;}
}
