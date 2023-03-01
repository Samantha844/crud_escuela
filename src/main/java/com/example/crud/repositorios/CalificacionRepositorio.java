package com.example.crud.repositorios;

import com.example.crud.modelos.Calificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface CalificacionRepositorio extends JpaRepository<Calificacion,Integer> {
    @Query("select c from Calificacion as c ")
    List<Calificacion> obtenerCalificacion();

    List<Calificacion> findAll();


}

