package com.example.api_vehiculos.model;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true) // Obligatorio al usar @Data con herencia
@NoArgsConstructor
public class Furgoneta extends Vehiculo {
    private Double capacidadCargaKg;

    public Furgoneta(long id, String marca, String modelo, Double precio, Double capacidadCargaKg) {
        super(id, marca, modelo, precio);
        this.capacidadCargaKg = capacidadCargaKg;
    }

}
