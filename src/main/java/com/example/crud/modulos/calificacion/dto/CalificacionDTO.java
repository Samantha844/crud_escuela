package com.example.crud.modulos.calificacion.dto;

import com.example.crud.modelos.Alumno;
import com.example.crud.modelos.Asignatura;
import com.example.crud.modelos.Calificacion;
import com.example.crud.modulos.persona.dto.PersonaDTO;

import java.util.Set;

public class CalificacionDTO {
    private Integer id_calificacion;
    private Integer semestre;
    private String materia;
    private Alumno alumno;
    private Asignatura asignatura;

    public CalificacionDTO(Calificacion calificacion) {
        this.id_calificacion = calificacion.getId_calificacion();
        this.semestre = calificacion.getSemestre();
        this.materia = calificacion.getMateria();
        this.alumno = calificacion.getAlumno();
        this.asignatura = calificacion.getAsignatura();

    }

    public CalificacionDTO(Integer idCalificacion, Integer semestre, String materia) {
        this.id_calificacion = id_calificacion;
        this.semestre = semestre;
        this.materia = materia;
    }

    public Integer getId_calificacion() {return id_calificacion;}

    public void setId_calificacion(Integer id_calificacion) {this.id_calificacion = id_calificacion;}

    public Integer getSemestre() {return semestre;}

    public void setSemestre(Integer semestre) {this.semestre = semestre;}

    public String getMateria() {return materia;}

    public void setMateria(String materia) {this.materia = materia;}

    public Alumno getAlumno() {return alumno;}

    public void setAlumno(Alumno alumno) {this.alumno = alumno;}

    public Asignatura getAsignatura() {return asignatura;}

    public void setAsignatura(Asignatura asignatura) {this.asignatura = asignatura;}
}
