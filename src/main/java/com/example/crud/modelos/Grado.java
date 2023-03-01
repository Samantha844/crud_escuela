package com.example.crud.modelos;

import javax.persistence.*;

@Entity
@Table(name = "grado")
public class Grado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column
    private Integer id_grado;
    @Column
    private String grado;
    @JoinColumn (name = "id_grupo",referencedColumnName = "id_grupo")
    @ManyToOne (fetch = FetchType.LAZY)
    private Grupo grupo;

    @JoinColumn (name = "id_alumno",referencedColumnName = "id_alumno")
    @ManyToOne (fetch = FetchType.LAZY)
    private Alumno alumno;

    public Grado(Grado grado) {
        this.id_grado = grado.getId_grado();
        this.grado = grado.getGrado();
        this.grupo = grado.getGrupo();
        this.alumno = grado.getAlumno();
    }

    public Grado() {

    }


    public Integer getId_grado() {return id_grado;}

    public void setId_grado(Integer id_grado) {this.id_grado = id_grado;}

    public String getGrado() {return grado;}

    public void setGrado(String grado) {grado = grado;}


    public Grupo getGrupo() {return grupo;}

    public void setGrupo(Grupo grupo) {this.grupo = grupo;}

    public Alumno getAlumno() {return alumno;}

    public void setAlumno(Alumno alumno) {this.alumno = alumno;}
}
