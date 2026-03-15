package com.example.api_vehiculos.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true) // Obligatorio al usar @Data con herencia
@NoArgsConstructor

public class Moto extends Vehiculo {

    private int cilindrada;

    public Moto(long id, String marca, String modelo, Double precio, int cilindrada) {
        super(id, marca, modelo, precio);
        this.cilindrada = cilindrada;
    }

    public Moto(int cilindrada) {
        this.cilindrada = cilindrada;
    }
}
