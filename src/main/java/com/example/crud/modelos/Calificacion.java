package com.example.crud.modelos;

import javax.persistence.*;
@Entity
@Table(name = "calificacion")
public class Calificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column
    private Integer id_calificacion;
    @Column
    private Integer semestre;
    @Column
    private String materia;
    @JoinColumn (name = "id_alumno",referencedColumnName = "id_alumno")
    @ManyToOne(fetch = FetchType.LAZY)
    private Alumno alumno;

    @JoinColumn (name = "id_asignatura",referencedColumnName = "id_asignatura")
    @ManyToOne(fetch = FetchType.LAZY)
    private Asignatura asignatura;


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

