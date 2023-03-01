package com.example.crud.modulos.docente.dto;

import com.example.crud.modelos.Docente;
import com.example.crud.modelos.Grupo;
import com.example.crud.modelos.Persona;

import java.util.Set;


public class DocenteDTO {

    private Integer id_docente;
    private String rfc;
    private Persona persona;
    private Grupo grupo;

    public DocenteDTO(Integer idDocente, String rfc) {
        this.id_docente = idDocente;
        this.rfc = rfc;
    }
    public DocenteDTO(Docente docente){
        this.id_docente = docente.getId_docente();
        this.rfc = docente.getRfc();
        this.persona =docente.getPersona();
        this.grupo = (Grupo) docente.getGrupo();
    }



    public Integer getId_docente() {return id_docente;}

    public void setId_docente(Integer id_docente) {this.id_docente = id_docente;}

    public String getRfc() {return rfc;}

    public void setRfc(String rfc) {this.rfc = rfc;}

    public Persona getPersona() {return persona;}

    public void setPersona(Persona persona) {this.persona = persona;}

    public Grupo getGrupo() {return grupo;}

    public void setGrupo(Grupo grupo) {this.grupo = grupo;}
}
