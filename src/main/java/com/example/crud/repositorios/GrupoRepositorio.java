package com.example.crud.repositorios;

import com.example.crud.modelos.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface GrupoRepositorio extends JpaRepository<Grupo,Integer> {
    @Query("select gru from Grupo as gru ")
    List<Grupo> obtenerGrupo();

    List<Grupo> findAll();
}
