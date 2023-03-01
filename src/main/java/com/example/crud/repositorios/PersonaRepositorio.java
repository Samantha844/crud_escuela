package com.example.crud.repositorios;

import com.example.crud.modelos.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface PersonaRepositorio extends JpaRepository<Persona,Integer> {
    @Query("select pe from Persona as pe ")
    List<Persona> obtenerPersona();

    List<Persona> findAll();
}
