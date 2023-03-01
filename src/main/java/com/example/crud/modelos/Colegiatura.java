package com.example.crud.modelos;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = "colegiatura")
public class Colegiatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column
    private Integer id_colegiatura;
    @Column
    private Integer monto;
    @Column
    private ZonedDateTime mes;
    @Column
    private Boolean pagado;

    @JoinColumn(name = "id_alumno", referencedColumnName = "id_alumno")
    @ManyToOne (fetch = FetchType.LAZY)
    private Alumno alumno;

    public Colegiatura() {
        this.id_colegiatura = getId_colegiatura();
        this.monto = getMonto();
        this.mes = getMes();
        this.pagado = getPagado();
        this.alumno = getAlumno();
    }

    public Integer getId_colegiatura() {return id_colegiatura;
    }

    public void setId_colegiatura(Integer id_colegiatura) {this.id_colegiatura = id_colegiatura;}

    public Alumno getAlumno() {return alumno;}

    public void setAlumno(Alumno alumno) {this.alumno = alumno;}

    public Integer getMonto() {return monto;}

    public void setMonto(Integer monto) {this.monto = monto;}

    public ZonedDateTime getMes() {return mes;}

    public void setMes(ZonedDateTime mes) {this.mes = mes;}

    public Boolean getPagado() {return pagado;}

    public void setPagado(Boolean pagado) {this.pagado = pagado;}
}
