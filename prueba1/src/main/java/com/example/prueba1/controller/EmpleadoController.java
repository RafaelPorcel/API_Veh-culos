package com.example.prueba1.controller;

import com.example.prueba1.model.Empleado;
import com.example.prueba1.model.EmpleadosTablas;
import com.example.prueba1.repository.EmpleadosTablasRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    /*List<Empleado> listaEmpleados = new ArrayList<>(List.of(
            new Empleado(1, "Rafa"),
            new Empleado(2, "Juan"),
            new Empleado(3, "Javier")
    ));*/

    private final EmpleadosTablasRepository empleadosTablasRepository;

    public EmpleadoController(EmpleadosTablasRepository empleadosTablasRepository) {
        this.empleadosTablasRepository = empleadosTablasRepository;
    }

    @GetMapping()
    public List<EmpleadosTablas> getEmpleados() {
        return (List<EmpleadosTablas>) empleadosTablasRepository.findAll();

        /*return listaEmpleados.stream()
                .sorted(Comparator.comparing(Empleado::getId))
                .collect(Collectors.toList());*/
    }

    @GetMapping("/empleado/{idEmpleado}")
    public ResponseEntity<EmpleadosTablas> getEmpleadosById(@PathVariable int idEmpleado) {//idEmpleado es una variable de ruta
        /*for (Empleado e : listaEmpleados) {
            if (e.getId() == idEmpleado) {
                return ResponseEntity.ok(e);
            }
        }
        return ResponseEntity.notFound().build();*/
        Optional<EmpleadosTablas> empleados = empleadosTablasRepository.findById(idEmpleado);
        if (empleados.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        EmpleadosTablas empleadosObj = empleados.get();
        return  ResponseEntity.ok(empleadosObj);
    }

    @PostMapping("crear_empleado")
    public ResponseEntity<EmpleadosTablas> postEmpleado(@RequestBody Empleado empleado) {
        /*listaEmpleados.add(empleado);
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("mensaje-postEmpleado", "Empleado creado correctamente")
                .body(empleado);*/
        EmpleadosTablas empleados = new EmpleadosTablas();
        empleados.setNombre(empleado.getNombre());

        EmpleadosTablas guardado = empleadosTablasRepository.save(empleados);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(guardado);


    }

}
