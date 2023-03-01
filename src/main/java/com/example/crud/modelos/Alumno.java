package com.example.crud.modelos;

import com.example.crud.modulos.alumno.dto.AlumnoDTO;

import javax.persistence.*;

@Entity
@Table(name = "alumno")
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_alumno")
    private Integer id_alumno;
    @Column
    private Integer matricula;
    @JoinColumn (name = "id_persona",referencedColumnName = "id_persona")
    @ManyToOne (fetch = FetchType.LAZY)
    private Persona persona;

    public Alumno() {
    }

    public Alumno(Integer id_alumno, Integer matricula, Persona persona) {
        this.id_alumno = id_alumno;
        this.matricula = matricula;
        this.persona = persona;
    }

    public Alumno(AlumnoDTO alumno) {
        this.id_alumno = alumno.getId_alumno();
        this.matricula = alumno.getMatricula();
    }

    public Alumno(Alumno alumno) {
        this.id_alumno = alumno.getId_alumno();
        this.matricula = alumno.getMatricula();
        this.persona = alumno.getPersona();
    }

    public Integer getId_alumno() {return id_alumno;}

    public void setId_alumno(Integer id_alumno) {this.id_alumno = id_alumno;}

    public Integer getMatricula() {return matricula;}

    public void setMatricula(Integer matricula) {this.matricula = matricula;}

    public Persona getPersona() {return persona;}

    public void setPersona(Persona persona) {this.persona = persona;}
}


