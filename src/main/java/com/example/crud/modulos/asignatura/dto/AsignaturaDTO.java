package com.example.crud.modulos.asignatura.dto;

import com.example.crud.modelos.Alumno;
import com.example.crud.modelos.Asignatura;

public class AsignaturaDTO {
    private Integer id_asignatura;
    private String nombre;
    private String descripcion;
    private Alumno alumno;

    public AsignaturaDTO(Asignatura asignatura) {
        this.id_asignatura = asignatura.getId_asignatura();
        this.nombre = asignatura.getNombre();
        this.descripcion = asignatura.getDescripcion();
        this.alumno = asignatura.getAlumno();
    }

    public AsignaturaDTO(Integer idAsignatura, String nombre, String descripcion) {
        this.id_asignatura = id_asignatura;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }


    public Integer getId_asignatura() {return id_asignatura;}

    public void setId_asignatura(Integer id_asignatura) {this.id_asignatura = id_asignatura;}

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getDescripcion() {return descripcion;}

    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}

    public Alumno getAlumno() {return alumno;}

    public void setAlumno(Alumno alumno) {this.alumno = alumno;}
}
