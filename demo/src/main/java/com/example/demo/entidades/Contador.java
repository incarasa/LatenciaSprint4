package com.example.demo.entidades;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;

@Document(collection = "contador")
public class Contador {
    @Id
    private String id;

    private long totalActualizados;


    // Getters y Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getTotalActualizados() {
        return totalActualizados;
    }

    public void setTotalActualizados(long totalActualizados) {
        this.totalActualizados = totalActualizados;
    }    

}
