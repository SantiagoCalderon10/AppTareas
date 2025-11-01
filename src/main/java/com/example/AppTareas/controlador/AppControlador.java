package com.example.AppTareas.controlador;

import com.example.AppTareas.modelo.Tarea;
import com.example.AppTareas.servicio.TareaServicio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Tag(name = "Gestión de Tareas (MVC)", description = "Controlador que maneja las vistas y operaciones del CRUD de tareas con Thymeleaf")
public class AppControlador {

    @Autowired
    private TareaServicio tareaServicio;

    @Operation(summary = "Mostrar pantalla de inicio", description = "Carga la vista principal con las opciones del sistema.")
    @GetMapping
    public String mostrarPantallaInicio() {
        return "inicio";
    }

    @Operation(summary = "Listar tareas", description = "Muestra la lista completa de tareas almacenadas.")
    @GetMapping("/tareas")
    public String mostrarTareas(Model model) {
        List<Tarea> tareas = tareaServicio.listarTareas();
        model.addAttribute("tareas", tareas);
        return "tareas";
    }

    @Operation(summary = "Mostrar formulario de agregar tarea", description = "Carga la vista con el formulario para registrar una nueva tarea.")
    @GetMapping("/tareas/agregar")
    public String mostrarAgregar(Model model) {
        model.addAttribute("tarea", new Tarea());
        return "agregar";
    }

    @Operation(summary = "Guardar nueva tarea", description = "Procesa el formulario para agregar una nueva tarea y redirige al listado.")
    @PostMapping("/tareas/agregar")
    public String agregarTarea(@ModelAttribute Tarea tarea) {
        tareaServicio.insertarTarea(tarea);
        return "redirect:/tareas";
    }

    @Operation(summary = "Eliminar tarea", description = "Elimina una tarea específica a partir de su identificador.")
    @Parameter(name = "id", description = "ID de la tarea a eliminar", required = true)
    @PostMapping("/tareas/eliminar/{id}")
    public String eliminarTarea(@PathVariable int id) {
        tareaServicio.eliminarTarea(id);
        return "redirect:/tareas";
    }

    @Operation(summary = "Mostrar formulario de edición", description = "Carga los datos de una tarea específica en el formulario de edición.")
    @Parameter(name = "id", description = "ID de la tarea a editar", required = true)
    @GetMapping("/tareas/editar/{id}")
    public String mostrarEditarTarea(@PathVariable int id, Model model) {
        Tarea tarea = tareaServicio.buscarTareaPorId(id);
        model.addAttribute("tarea", tarea);
        return "editar";
    }

    @Operation(summary = "Actualizar tarea", description = "Procesa el formulario de edición y actualiza la tarea existente.")
    @PostMapping("/tareas/editar")
    public String editarTarea(@ModelAttribute Tarea tarea) {
        tareaServicio.insertarTarea(tarea);
        return "redirect:/tareas";
    }
}
