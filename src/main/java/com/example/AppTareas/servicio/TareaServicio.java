package com.example.AppTareas.servicio;


import com.example.AppTareas.modelo.Tarea;
import com.example.AppTareas.repositorio.TareaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaServicio {

    @Autowired
    private TareaRepositorio tareaRepositorio;


    public List<Tarea> listarTareas() {
        return tareaRepositorio.findAll();
    }

    public Tarea buscarTareaPorId(int id) {
        return tareaRepositorio.findById(id).get();
    }

    public void insertarTarea(Tarea tarea) {
        tareaRepositorio.save(tarea);
    }

    public void eliminarTarea(int id) {
        tareaRepositorio.deleteById(id);
    }


}
