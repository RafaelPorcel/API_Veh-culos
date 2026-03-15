package com.example.api_vehiculos.controller;

import com.example.api_vehiculos.model.Vehiculo;
import com.example.api_vehiculos.service.VehiculoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/vehiculos") // Define la ruta principal para todos los endpoints de aquí
public class VehiculoController {

    // 1. Declaramos el servicio
    private final VehiculoService vehiculoService;

    // 2. Inyección de dependencias (Spring crea el servicio y lo mete aquí automáticamente)
    public VehiculoController(VehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    // 3. El Endpoint
    // Si la ruta base es "/api/vehiculos" y aquí pones "/lista",
    // la URL final en Postman será: GET http://localhost:8080/api/vehiculos/lista
    @GetMapping("/lista")
    public List<Vehiculo> obtenerTodosLosVehiculos() {
        // El controlador llama al servicio, y devuelve lo que el servicio responda
        return vehiculoService.listarVehiculos();
    }
}
