package com.example.crud.modelos;

import com.example.crud.modulos.asignatura.dto.AsignaturaDTO;
import com.example.crud.modulos.persona.dto.PersonaDTO;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "asignatura")
public class Asignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column
    private Integer id_asignatura;
    @Column
    private String nombre;
    @Column
    private String descripcion;
    @JoinColumn (name = "id_alumno",referencedColumnName = "id_alumno")
    @ManyToOne (fetch = FetchType.LAZY)
    private Alumno alumno;

    @OneToMany (mappedBy = "asignatura")
    private Set<Calificacion> calificacion;

    public Asignatura(Asignatura asignatura) {
        this.id_asignatura = asignatura.getId_asignatura();
        this.nombre = asignatura.getNombre();
        this.descripcion = asignatura.getDescripcion();
    }

    public Asignatura() {
    }



    public Integer getId_asignatura() {return id_asignatura;}

    public void setId_asignatura(Integer id_asignatura) {this.id_asignatura = id_asignatura;}

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getDescripcion() {return descripcion;}

    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}

    public Alumno getAlumno() {return alumno;}

    public void setAlumno(Alumno alumno) {this.alumno = alumno;}

    public Set<Calificacion> getCalificacion() {return calificacion;}

    public void setCalificacion(Set<Calificacion> calificacion) {this.calificacion = calificacion;}
}
