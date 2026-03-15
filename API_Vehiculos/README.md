# 🚗 Ejercicio Práctico: Sistema de Gestión de Flota (Concesionario REST API)

**Módulo:** Spring Boot y Arquitectura MVC
**Objetivo:** Crear una API RESTful para gestionar un inventario de distintos tipos de vehículos aplicando herencia, 
    Optionals y Streams.

---

## 🛠️ Paso 1: Configuración del Proyecto
1. Ve a **Spring Initializr** (start.spring.io).
2. Crea un proyecto Maven con Java.
3. Añade la dependencia: **Spring Web**.
4. (Opcional) Añade **Lombok** para reducir el código repetitivo (getters, setters, constructores).

---

## 📦 Paso 2: Creación de Modelos (Paquete `model`)
Implementa la siguiente jerarquía de clases para repasar la programación orientada a objetos:

**1. Clase Padre `Vehiculo` (Abstracta)**
- `id` (Long)
- `marca` (String)
- `modelo` (String)
- `precio` (Double)

**2. Clases Hijas**
- `Coche`: Añade el atributo `numPuertas` (int).
- `Moto`: Añade el atributo `cilindrada` (int).
- `Furgoneta`: Añade el atributo `capacidadCargaKg` (double).
- `Camion`: Añade el atributo `numEjes` (int).

*Nota de investigación:* Para que la API sepa leer JSONs con diferentes tipos de vehículos, investigad sobre las 
anotaciones `@JsonTypeInfo` y `@JsonSubTypes` de la librería Jackson.

---

## ⚙️ Paso 3: Lógica de Negocio (Paquete `service`)
Crea la clase `VehiculoService`. Utiliza una lista estática en memoria para simular la base de datos:
`List<Vehiculo> inventario = new ArrayList<>();`

Crea los métodos necesarios para:
1. Guardar un vehículo nuevo.
2. Obtener todos los vehículos.
3. Obtener un vehículo por ID (Debe devolver un `Optional<Vehiculo>`).
4. Actualizar un vehículo existente.
5. Eliminar un vehículo.

---

## 🌐 Paso 4: Creación de Endpoints (Paquete `controller`)
Crea la clase `VehiculoController`. Anótala con `@RestController` y `@RequestMapping("/api/vehiculos")`. 
Expon los siguientes endpoints:

- **GET `/api/vehiculos`**: Devuelve el inventario completo. Status 200 OK.
- **GET `/api/vehiculos/{id}`**: Devuelve el vehículo solicitado. Si el `Optional` viene vacío, devuelve un Status 404 
  - (Not Found).
- **POST `/api/vehiculos`**: Recibe el JSON de un vehículo y lo guarda. Status 201 Created.
- **PUT `/api/vehiculos/{id}`**: Actualiza los datos de un vehículo existente.
- **DELETE `/api/vehiculos/{id}`**: Borra el vehículo indicado. Status 204 No Content.

---

## 🧠 Paso 5: Retos Extra (Repaso de Java Avanzado)
Añade estos endpoints adicionales en tu controlador y resuélvelos en el servicio usando **Java Streams**:

1. **GET `/api/vehiculos/filtrar?marca={nombreMarca}`**
    - Recibe la marca por parámetro de consulta (`@RequestParam`).
    - Usa `.stream().filter(...)` para devolver solo los vehículos de esa marca.

2. **GET `/api/vehiculos/motos`**
    - Usa un Stream para filtrar la lista principal y devolver únicamente los objetos que sean instancia de Moto 
    - (`instanceof Moto`).

---

## 🧪 Datos de Prueba para Postman

**Ejemplo POST Coche:**
{
"tipo": "coche",
"id": 1,
"marca": "Toyota",
"modelo": "Corolla",
"precio": 22000.0,
"numPuertas": 5
}

**Ejemplo POST Moto:**
{
"tipo": "moto",
"id": 2,
"marca": "Honda",
"modelo": "CBR600",
"precio": 9500.0,
"cilindrada": 600
}