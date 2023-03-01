package com.example.crud.modelos;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "docente")
public class Docente  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column
    private Integer id_docente;

    @Column
    private String rfc;

    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    @ManyToOne (fetch = FetchType.LAZY)
    private Persona persona;

    @OneToMany(mappedBy = "docente")
    private Set<Grupo> grupo;

    public Docente(Docente docente) {
        this.id_docente = docente.getId_docente();
        this.rfc = docente.getRfc();
        this.persona = docente.getPersona();
        this.grupo = docente.getGrupo();
    }

    public Docente() {

    }


    public Integer getId_docente() {return id_docente;}

    public void setId_docente(Integer id_docente) {this.id_docente = id_docente;}

    public String getRfc() {return rfc;}

    public void setRfc(String rfc) {this.rfc = rfc;}

    public Persona getPersona() {return persona;}

    public void setPersona(Persona persona) {this.persona = persona;}

    public Set<Grupo> getGrupo() {return grupo;}

    public void setGrupo(Set<Grupo> grupo) {this.grupo = grupo;}
}
