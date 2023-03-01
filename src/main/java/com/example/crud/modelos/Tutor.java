package com.example.crud.modelos;

import com.example.crud.modelos.Alumno;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tutor")
public class Tutor{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column
    private Integer id_tutor;
    @Column
    private String perfil;

    @JoinColumn (name = "id_alumno",referencedColumnName = "id_alumno")
    @ManyToOne (fetch = FetchType.LAZY)
    private Alumno alumno;
    @JoinColumn (name = "id_persona",referencedColumnName = "id_persona")
    @ManyToOne (fetch = FetchType.LAZY)
    private Persona persona;


    public Integer getId_tutor() {return id_tutor;}

    public void setId_tutor(Integer id_tutor) {this.id_tutor = id_tutor;}

    public String getPerfil() {return perfil;}

    public void setPerfil(String perfil) {this.perfil = perfil;}

    public Alumno getAlumno() {return alumno;}

    public void setAlumno(Alumno alumno) {this.alumno = alumno;}

    public Persona getPersona() {return persona;}

    public void setPersona(Persona persona) {this.persona = persona;}
}
