package com.example.prueba1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@Data
public class EmpleadosTablas {

    @Id
    private int id;
    private String nombre;

    public EmpleadosTablas() {

    }
}
