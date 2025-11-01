package com.example.AppTareas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.AppTareas.modelo.Tarea;
import org.springframework.stereotype.Repository;


@Repository
public interface TareaRepositorio extends JpaRepository<Tarea, Integer> {
}
