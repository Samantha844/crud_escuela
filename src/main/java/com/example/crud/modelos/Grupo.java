package com.example.crud.modelos;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "grupo")
public class Grupo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column
    private Integer id_grupo;
    @Column
    private String nombre;
    @JoinColumn (name = "id_docente",referencedColumnName = "id_docente")
    @ManyToOne (fetch = FetchType.LAZY)
    private Docente docente;
    @OneToMany(mappedBy = "grado")
    private Set<Grado> grado;

    public Grupo(Grupo grupo) {
        this.id_grupo = grupo.getId_grupo();
        this.nombre = grupo.getNombre();
        this.docente = grupo.getDocente();
        this.grado = grupo.getGrado();
    }

    public Grupo() {
        this.id_grupo= getId_grupo();
        this.nombre = getNombre();
        this.docente = getDocente();
        this.grado = getGrado();
    }

    public Integer getId_grupo() {return id_grupo;}

    public void setId_grupo(Integer id_grupo) {this.id_grupo = id_grupo;}

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public Docente getDocente() {return docente;}

    public void setDocente(Docente docente) {this.docente = docente;}

    public Set<Grado> getGrado() {return grado;}

    public void setGrado(Set<Grado> grado) {this.grado = grado;}
}
