package com.example.crud.repositorios;

import com.example.crud.modelos.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository

public interface AlumnoRepositorio extends JpaRepository<Alumno,Integer>{
    @Query("select a from Alumno as a ")
    List<Alumno> obtenerAlumno();

    List<Alumno> findAll();


}