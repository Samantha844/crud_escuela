package com.example.crud.modulos.alumno.dto;

import com.example.crud.modelos.Alumno;
import com.example.crud.modelos.Persona;
import com.example.crud.modulos.persona.dto.PersonaDTO;


public class AlumnoDTO {

    private Integer id_alumno;
    private Integer matricula;

    private PersonaDTO persona;


    public AlumnoDTO(Integer id_alumno, Integer matricula) {
        this.id_alumno = id_alumno;
        this.matricula = matricula;
    }

    public AlumnoDTO(Alumno alumno) {
        this.id_alumno = alumno.getId_alumno();
        this.matricula = alumno.getMatricula();
        this.persona = new PersonaDTO(alumno.getPersona());
    }

    public Integer getId_alumno() {return id_alumno;}

    public void setId_alumno(Integer id_alumno) {this.id_alumno = id_alumno;}

    public Integer getMatricula() {return matricula;}

    public void setMatricula(Integer matricula) {this.matricula = matricula;}

    public PersonaDTO getPersona() {return persona;}

    public void setPersona(PersonaDTO persona) {this.persona = persona;}
}
