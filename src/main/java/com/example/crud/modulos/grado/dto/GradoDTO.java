package com.example.crud.modulos.grado.dto;

import com.example.crud.modelos.Alumno;
import com.example.crud.modelos.Grado;
import com.example.crud.modelos.Grupo;
import com.example.crud.modulos.persona.dto.PersonaDTO;


public class GradoDTO {
    private Integer id_grado;
    private String grado;
    private Grupo grupo;
    private Alumno alumno;

    public GradoDTO(Integer idGrado, String grado) {
        this.id_grado= idGrado;
        this.grado = grado;
    }

    public GradoDTO(Grado grado) {
        this.id_grado = grado.getId_grado();
        this.grado = grado.getGrado();
        this.grupo = new Grupo(grado.getGrupo());
        this.alumno = new Alumno(grado.getAlumno());
    }


    public Integer getId_grado() {return id_grado;}

    public void setId_grado(Integer id_grado) {this.id_grado = id_grado;}

    public String getGrado() {return grado;}

    public void setGrado(String grado) {this.grado = grado;}

    public Grupo getGrupo() {return grupo;}

    public void setGrupo(Grupo grupo) {this.grupo = grupo;}

    public Alumno getAlumno() {return alumno;}

    public void setAlumno(Alumno alumno) {this.alumno = alumno;}
}
