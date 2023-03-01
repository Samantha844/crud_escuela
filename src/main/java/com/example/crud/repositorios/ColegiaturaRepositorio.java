package com.example.crud.repositorios;

import com.example.crud.modelos.Colegiatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ColegiaturaRepositorio extends JpaRepository<Colegiatura,Integer>{
    @Query("select col from Colegiatura as col ")
    List<Colegiatura> obtenerColegiatura();
    List<Colegiatura> findAll();
}
