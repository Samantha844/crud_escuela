package com.example.crud.modelos;

import com.example.crud.modulos.persona.dto.PersonaDTO;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id_persona;
    @Column
    private String nombre;
    @Column
    private String apellido_paterno;
    @Column
    private String apellido_materno;
    @Column
    private String genero;
    @Column
    private String curp;
    @Column
    private String direccion;
    @Column
    private Integer telefono;
    @Column
    private String correo;
    @OneToMany(mappedBy = "persona")
    private Set<Tutor> tutor;
    @OneToMany(mappedBy = "persona")
    private Set<Alumno> alumno;
    @OneToMany (mappedBy = "persona")
    private Set<Docente> docente;



    public Persona() {
    }

    public Persona(String nombre, String apellido_paterno, String apellido_materno, String genero, String curp, String direccion, Integer telefono, String correo) {
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.genero = genero;
        this.curp = curp;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
    }

    public Persona(PersonaDTO persona) {
        this.id_persona = persona.getId_persona();
        this.nombre = persona.getNombre();
        this.apellido_paterno = persona.getApellido_paterno();
        this.apellido_materno = persona.getApellido_paterno();
        this.genero = persona.getGenero();
        this.curp = persona.getCurp();
        this.direccion = persona.getDireccion();
        this.telefono = persona.getTelefono();
        this.correo = persona.getCorreo();
    }

    public Persona(Persona persona) {
        this.id_persona = persona.getId_persona();
        this.nombre = persona.getNombre();
        this.apellido_paterno = persona.getApellido_paterno();
        this.apellido_materno = persona.getApellido_paterno();
        this.genero = persona.getGenero();
        this.curp = persona.getCurp();
        this.direccion = persona.getDireccion();
        this.telefono = persona.getTelefono();
        this.correo = persona.getCorreo();
    }

    public Integer getId_persona() {return id_persona;}

    public void setId_persona(Integer id_persona) {this.id_persona = id_persona;}

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getApellido_paterno() {return apellido_paterno;}

    public void setApellido_paterno(String apellido_paterno) {this.apellido_paterno = apellido_paterno;}

    public String getApellido_materno() {return apellido_materno;}

    public void setApellido_materno(String apellido_materno) {this.apellido_materno = apellido_materno;}

    public String getGenero() {return genero;}

    public void setGenero(String genero) {this.genero = genero;}

    public String getCurp() {return curp;}

    public void setCurp(String curp) {this.curp = curp;}

    public String getDireccion() {return direccion;}

    public void setDireccion(String direccion) {this.direccion = direccion;}

    public Integer getTelefono() {return telefono;}

    public void setTelefono(Integer telefono) {this.telefono = telefono;}

    public String getCorreo() {return correo;}

    public void setCorreo(String correo) {this.correo = correo;}

    public Set<Tutor> getTutor() {return tutor;}

    public void setTutor(Set<Tutor> tutor) {this.tutor = tutor;}

    public Set<Alumno> getAlumno() {return alumno;}

    public void setAlumno(Set<Alumno> alumno) {this.alumno = alumno;}

    public Set<Docente> getDocente() {return docente;}

    public void setDocente(Set<Docente> docente) {this.docente = docente;}
}
