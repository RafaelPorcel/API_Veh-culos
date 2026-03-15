package com.example.api_vehiculos.service;

import com.example.api_vehiculos.model.*;
import org.apache.logging.log4j.util.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.util.comparator.Comparators;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehiculoService {

    // Envolvemos el List.of en un ArrayList para que sea mutable (permita add y remove)
    private List<Vehiculo> inventario = new ArrayList<>(List.of(
            // Coches (id, marca, modelo, precio, numPuertas)
            new Coche(1L, "Toyota", "Corolla", 22000.0, 5),
            new Coche(2L, "Seat", "Ibiza", 15000.0, 5),
            new Coche(3L, "Ford", "Mustang", 45000.0, 3),
            new Coche(4L, "Renault", "Clio", 14000.0, 5),
            new Coche(5L, "BMW", "Serie 3", 35000.0, 5),

            // Motos (id, marca, modelo, precio, cilindrada)
            new Moto(6L, "Yamaha", "MT-07", 7000.0, 689),
            new Moto(7L, "Honda", "CBR600", 9500.0, 600),
            new Moto(8L, "Kawasaki", "Ninja 400", 6000.0, 399),
            new Moto(9L, "Ducati", "Monster", 11000.0, 937),
            new Moto(10L, "Suzuki", "SV650", 6500.0, 645),

            // Furgonetas (id, marca, modelo, precio, capacidadCarga)
            new Furgoneta(11L, "Mercedes", "Sprinter", 28000.0, 3500.0),
            new Furgoneta(12L, "Ford", "Transit", 25000.0, 3000.0),
            new Furgoneta(13L, "Volkswagen", "Crafter", 29000.0, 3500.0),
            new Furgoneta(14L, "Renault", "Kangoo", 18000.0, 800.0),
            new Furgoneta(15L, "Peugeot", "Partner", 17500.0, 850.0),

            // Camiones (id, marca, modelo, precio, numEjes)
            new Camion(16L, "Volvo", "FH16", 120000.0, 4, 5000.5),
            new Camion(17L, "Scania", "R500", 115000.0, 3, 2600.7),
            new Camion(18L, "MAN", "TGX", 110000.0, 3, 6300.5),
            new Camion(19L, "Mercedes", "Actros", 125000.0, 4, 5200.9),
            new Camion(20L, "Iveco", "S-Way", 105000.0, 2, 2000.0)
    ));

    public List<Vehiculo> listarVehiculos() {
        return this.inventario.stream()
                .sorted(Comparator.comparing(Vehiculo::getId))
                .collect(Collectors.toList());
    }

    public Optional<Vehiculo> obtenerVehiculoPorId(Long id) {
        for (Vehiculo v : this.inventario) {
            if (id == v.getId()) {
                return Optional.ofNullable(v);
            }
        }
        return Optional.empty();
    }

    /*public Boolean insertarVehiculo(Vehiculo vehiculo) {
        for (Vehiculo v : this.inventario) {
            if (v.getId() == vehiculo.getId()){
                return false;
            }else {
                this.inventario.add(vehiculo);
            }
        }return true;
    }*/

    public Boolean insertarVehiculo(Vehiculo vehiculo) {
        // 1. Recorremos toda la lista solo para comprobar
        for (Vehiculo v : this.inventario) {
            if (v.getId() == vehiculo.getId()) {
                // Si encontramos un ID igual, paramos todo y devolvemos false
                return false;
            }
        }

        // 2. Si el código llega hasta aquí, significa que el bucle terminó
        // y no encontró ningún ID repetido. ¡Ahora sí podemos añadirlo!
        this.inventario.add(vehiculo);
        return true;
    }


}
