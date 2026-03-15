package com.example.api_vehiculos.controller;

import com.example.api_vehiculos.model.Vehiculo;
import com.example.api_vehiculos.service.VehiculoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vehiculos") // Define la ruta principal para todos los endpoints de aquí
public class VehiculoController {

    // 1. Declaramos el servicio
    private final VehiculoService vehiculoService;

    // 2. Inyección de dependencias (Spring crea el servicio y lo mete aquí automáticamente)
    public VehiculoController(VehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    @GetMapping("/lista")
    public List<Vehiculo> obtenerTodosLosVehiculos() {
        // El controlador llama al servicio, y devuelve lo que el servicio responda
        return vehiculoService.listarVehiculos();
    }

    @GetMapping("/buscar_id/{id}")
    public ResponseEntity<Object> obtenerVehiculoId(@PathVariable Long id) {

        // 1. Pedimos el Optional al servicio
        Optional<Vehiculo> vehiculoOptionalId = vehiculoService.obtenerVehiculoPorId(id);

        // 2. Comprobamos si hay algo dentro
        if (vehiculoOptionalId.isPresent()) {
            // Si existe, devolvemos un 200 OK y el vehículo en formato JSON
            return ResponseEntity.ok(vehiculoOptionalId.get());
        } else {
            // Si está vacío, devolvemos un 404 Not Found y tu mensaje personalizado
            String mensaje = "Error: No se ha encontrado ningún vehículo con el ID " + id;
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensaje);
        }
    }

    @PostMapping("/agregar_vehiculo")
    public ResponseEntity<Object> agregarVehiculo(@RequestBody Vehiculo vehiculo) {
        boolean hayVehiculo = vehiculoService.insertarVehiculo(vehiculo);
        if (hayVehiculo){
            return ResponseEntity.status(HttpStatus.CREATED).body("Vehículo insertado correctamente");
        }else{
            return ResponseEntity.status(HttpStatus.CONFLICT).body("El id del vehículo ya existe");
        }
    }




}
