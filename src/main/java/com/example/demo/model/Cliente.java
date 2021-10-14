package com.example.demo.model;

import lombok.Data;
import lombok.NonNull;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;


@Data
@Entity

public class Cliente {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @NonNull
    private String nombre;
    @NonNull
    private Integer telefono;

    public Cliente(){
        this.id = 0L;
        this.telefono = 0;
        this.nombre = "";
    }
    public Cliente(Long id, String nombre, Integer telefono){
        this.id = id;
        this.telefono = telefono;
        this.nombre = nombre;
    }

}
