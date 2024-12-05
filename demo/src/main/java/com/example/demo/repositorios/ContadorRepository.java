package com.example.demo.repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entidades.Contador;

public interface ContadorRepository extends MongoRepository<Contador, String> {
    
}