package com.example.crud.repositorios;

import com.example.crud.modelos.Grado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface GradoRepositorio extends JpaRepository<Grado,Integer> {
    @Query("select gra from Grado as gra ")
    List<Grado> obtenerGrado();

    List<Grado> findAll();
}
