package com.example.api_vehiculos.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
// 👇 Esto le dice a Spring: "Fíjate en el campo 'tipo' del JSON para saber qué clase hija crear"
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "tipo")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Coche.class, name = "coche"),
        @JsonSubTypes.Type(value = Moto.class, name = "moto")
})
public abstract class Vehiculo {

    private long id;
    private String marca;
    private String modelo;
    private Double precio;


}
