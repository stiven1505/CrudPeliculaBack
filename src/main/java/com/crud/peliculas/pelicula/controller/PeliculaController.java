package com.crud.peliculas.pelicula.controller;

import com.crud.peliculas.pelicula.model.ServiceResponse;
import com.crud.peliculas.pelicula.model.PeliculaModel;
import com.crud.peliculas.pelicula.service.IPeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para manejar las solicitudes relacionadas con la entidad Película.
 * Expone endpoints para las operaciones CRUD (listar, guardar, actualizar y eliminar).
 */
@RestController
@RequestMapping("api/v1/pelicula") // Ruta base para las solicitudes de películas.
@CrossOrigin("*") // Permite solicitudes desde cualquier origen (considerar restringir a dominios específicos en producción).
public class PeliculaController {

    // Inyección de dependencia del servicio de película
    @Autowired
    private IPeliculaService iPeliculaService;

    /**
     * Endpoint para listar todas las películas.
     * @return ResponseEntity con una lista de películas.
     */
    @GetMapping("/list")
    public ResponseEntity<List<PeliculaModel>> list() {
        // Llama al servicio para obtener todas las películas
        List<PeliculaModel> result = iPeliculaService.findAll();

        // Retorna una respuesta con el estado HTTP 200 (OK) y la lista de películas.
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * Endpoint para guardar una nueva película.
     * @param peliculaModel Objeto que representa la película a guardar.
     * @return ResponseEntity con el mensaje de éxito o error.
     */
    @PostMapping("/save")
    public ResponseEntity<ServiceResponse> save(@RequestBody PeliculaModel peliculaModel) {
        ServiceResponse response = new ServiceResponse();
        try {
            // Llama al servicio para guardar la película
            int result = iPeliculaService.save(peliculaModel);

            // Si la película se guarda correctamente, retorna un mensaje de éxito
            if (result == 1) {
                response.setMessage("Película guardada exitosamente");
                return ResponseEntity.ok(response);
            } else {
                // Si ocurre un error al guardar la película, retorna un mensaje de error.
                response.setMessage("Error al guardar la película.");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            }
        } catch (Exception e) {
            // En caso de una excepción, captura el error y retorna una respuesta con el mensaje.
            e.printStackTrace();
            response.setMessage("Error al guardar la película: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    /**
     * Endpoint para actualizar una película existente.
     * @param peliculaModel Objeto que contiene los datos de la película a actualizar.
     * @return ResponseEntity con el mensaje de éxito o error.
     */
    @PostMapping("/update")
    public ResponseEntity<ServiceResponse> update(@RequestBody PeliculaModel peliculaModel) {
        ServiceResponse serviceResponse = new ServiceResponse();

        try {
            // Llama al servicio para actualizar la película
            int result = iPeliculaService.update(peliculaModel);

            // Si la actualización es exitosa, retorna un mensaje de éxito.
            if (result == 1) {
                serviceResponse.setMessage("Película actualizada exitosamente");
                return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
            } else {
                // Si la película no se encuentra, retorna un mensaje de error.
                serviceResponse.setMessage("Error al actualizar la película: Película no encontrada");
                return new ResponseEntity<>(serviceResponse, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            // En caso de una excepción, captura el error y retorna una respuesta con el mensaje.
            serviceResponse.setMessage("Error al actualizar la película: " + e.getMessage());
            return new ResponseEntity<>(serviceResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Endpoint para eliminar una película por su ID.
     * @param id El ID de la película a eliminar.
     * @return ResponseEntity con el mensaje de éxito o error.
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ServiceResponse> delete(@PathVariable int id) {
        ServiceResponse serviceResponse = new ServiceResponse();

        try {
            // Llama al servicio para eliminar la película por su ID
            int result = iPeliculaService.deleteById(id);

            // Si la película se elimina correctamente, retorna un mensaje de éxito.
            if (result == 1) {
                serviceResponse.setMessage("Película eliminada exitosamente.");
                return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
            } else {
                // Si la película no se encuentra, retorna un mensaje de error.
                serviceResponse.setMessage("Película no encontrada.");
                return new ResponseEntity<>(serviceResponse, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            // En caso de una excepción, captura el error y retorna una respuesta con el mensaje.
            serviceResponse.setMessage("Error al eliminar la película: " + e.getMessage());
            return new ResponseEntity<>(serviceResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    /**
 * Endpoint para actualizar el estado de alquiler de una película.
 * @param id El ID de la película.
 * @param estadoAlquiler El nuevo estado de alquiler (por ejemplo, "Alquilado", "Disponible").
 * @return ResponseEntity con el mensaje de éxito o error.
 */
@PutMapping("/updateEstadoAlquiler/{id}")
public ResponseEntity<ServiceResponse> updateEstadoAlquiler(@PathVariable int id, @RequestBody String estadoAlquiler) {
    ServiceResponse serviceResponse = new ServiceResponse();

    try {
        // Llama al servicio para actualizar el estado de alquiler
        int result = iPeliculaService.updateEstadoAlquiler(id, estadoAlquiler);

        // Si la actualización es exitosa, retorna un mensaje de éxito.
        if (result == 1) {
            serviceResponse.setMessage("Estado de alquiler actualizado exitosamente");
            return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
        } else {
            // Si no se encuentra la película, retorna un mensaje de error.
            serviceResponse.setMessage("Película no encontrada.");
            return new ResponseEntity<>(serviceResponse, HttpStatus.NOT_FOUND);
        }
    } catch (Exception e) {
        // En caso de una excepción, captura el error y retorna una respuesta con el mensaje.
        serviceResponse.setMessage("Error al actualizar el estado de alquiler: " + e.getMessage());
        return new ResponseEntity<>(serviceResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

}
