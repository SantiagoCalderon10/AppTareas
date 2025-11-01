package com.example.AppTareas.modelo;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tareas")
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false)
    private String descripcion;

    @Column
    private boolean compleada;


    public boolean isCompleada() {
        return compleada;
    }

    public void setCompleada(boolean compleada) {
        this.compleada = compleada;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEstado(){
        return compleada ? "Sí" : "No";
    }
}
