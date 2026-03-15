package com.example.api_vehiculos.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true) // Obligatorio al usar @Data con herencia
@NoArgsConstructor

public class Coche extends Vehiculo{
    private int numPuertas;

    public Coche(long id, String marca, String modelo, Double precio, int numPuertas) {
        super(id, marca, modelo, precio);
        this.numPuertas = numPuertas;
    }

}
