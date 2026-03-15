package com.example.api_vehiculos.model;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true) // Obligatorio al usar @Data con herencia
@NoArgsConstructor
public class Camion extends Vehiculo {
    private int numEjes;
    private double capacidadCargaKg;

    public Camion(long id, String marca, String modelo, Double precio, int numEjes, double capacidadCargaKg) {
        super(id, marca, modelo, precio);
        this.numEjes = numEjes;
        this.capacidadCargaKg = capacidadCargaKg;
    }

}
