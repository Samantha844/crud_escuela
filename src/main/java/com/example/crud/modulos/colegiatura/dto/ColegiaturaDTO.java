package com.example.crud.modulos.colegiatura.dto;

import com.example.crud.modelos.Alumno;
import com.example.crud.modelos.Colegiatura;
import com.example.crud.modulos.persona.dto.PersonaDTO;

import java.time.ZonedDateTime;
import java.util.BitSet;

public class ColegiaturaDTO {

    private Integer id_colegiatura;
    private Integer monto;
    private ZonedDateTime mes;
    private Boolean pagado;
    private Alumno alumno;

    public ColegiaturaDTO(Integer id_colegiatura, Integer monto, ZonedDateTime mes, Boolean pagado) {
        this.id_colegiatura = id_colegiatura;
        this.monto = monto;
        this.mes = mes;
        this.pagado = pagado;
    }

     public ColegiaturaDTO(Colegiatura colegiatura){
        this.id_colegiatura = colegiatura.getId_colegiatura();
        this.monto = colegiatura.getMonto();
        this.mes = colegiatura.getMes();
        this.pagado = colegiatura.getPagado();
        this.alumno = colegiatura.getAlumno();

    }


    public Integer getId_colegiatura() {return id_colegiatura;}

    public void setId_colegiatura(Integer id_colegiatura) {this.id_colegiatura = id_colegiatura;}

    public Integer getMonto() {return monto;}

    public void setMonto(Integer monto) {this.monto = monto;}

    public ZonedDateTime getMes() {return mes;}

    public void setMes(ZonedDateTime mes) {this.mes = mes;}

    public Boolean getPagado() {return pagado;}

    public void setPagado(Boolean pagado) {this.pagado = pagado;}

    public Alumno getAlumno() {return alumno;}

    public void setAlumno(Alumno alumno) {this.alumno = alumno;}
}
