package com.example.crud.repositorios;

import com.example.crud.modelos.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface DocenteRepositorio extends JpaRepository<Docente,Integer> {
    @Query("select do from Docente as do ")
    List<Docente> obtenerDocente();

    List<Docente> findAll();
}