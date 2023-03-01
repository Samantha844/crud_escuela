package com.example.crud.repositorios;

import com.example.crud.modelos.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface TutorRepositorio extends JpaRepository<Tutor,Integer> {
    @Query("select tu from Grado as tu ")
    List<Tutor> obtenerTutor();

    List<Tutor> findAll();
}
