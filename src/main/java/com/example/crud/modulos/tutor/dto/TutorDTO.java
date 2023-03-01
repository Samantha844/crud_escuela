package com.example.crud.modulos.tutor.dto;

import com.example.crud.modelos.Alumno;
import com.example.crud.modelos.Persona;
import com.example.crud.modelos.Tutor;


public class TutorDTO {

    private Integer id_tutor;
    private String perfil;
    private Alumno alumno;
    private Persona persona;

    public TutorDTO(Integer idTutor, String perfil) {
        this.id_tutor = idTutor;
        this.perfil = perfil;
    }
    public TutorDTO( Tutor tutor){
        this.id_tutor = tutor.getId_tutor();
        this.perfil = tutor.getPerfil();
        this.alumno = tutor.getAlumno();
        this.persona = tutor.getPersona();
    }

    public Integer getId_tutor() {return id_tutor;}

    public void setId_tutor(Integer id_tutor) {this.id_tutor = id_tutor;}

    public String getPerfil() {return perfil;}

    public void setPerfil(String perfil) {this.perfil = perfil;}

    public Alumno getAlumno() {return alumno;}

    public void setAlumno(Alumno alumno) {this.alumno = alumno;}

    public Persona getPersona() {return persona;}

    public void setPersona(Persona persona) {this.persona = persona;}
}
