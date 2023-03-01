package com.example.crud.repositorios;

import com.example.crud.modelos.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface AsignaturaRepositorio extends JpaRepository<Asignatura,Integer>{
    @Query("select asi from Asignatura as asi ")
    List<Asignatura> obtenerAsignatura();

    List<Asignatura> findAll();

}
