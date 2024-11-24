package com.crud.peliculas.pelicula.service;

import com.crud.peliculas.pelicula.model.PeliculaModel;
import com.crud.peliculas.pelicula.repository.IPeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class PeliculaService implements IPeliculaService {

    // Logger para registrar eventos y errores
    private static final Logger logger = LoggerFactory.getLogger(PeliculaService.class);

    @Autowired
    private IPeliculaRepository iPeliculaRepository;

    /**
     * Obtiene una lista de todas las películas almacenadas en la base de datos.
     *
     * @return Lista de objetos PeliculaModel con los datos de las películas.
     */
    @Override
    public List<PeliculaModel> findAll() {
        try {
            // Llama al repositorio para obtener las películas
            return iPeliculaRepository.findAll();
        } catch (Exception e) {
            // Registra el error en caso de que falle la operación
            logger.error("Error al obtener la lista de películas: {}", e.getMessage());
            throw new RuntimeException("Error al obtener la lista de películas", e);
        }
    }

    /**
     * Guarda una nueva película en la base de datos.
     *
     * @param peliculaModel El modelo de la película que se va a guardar.
     * @return Número de filas afectadas (1 si la operación fue exitosa, 0 si falló).
     */
    @Override
    public int save(PeliculaModel peliculaModel) {
        try {
            // Llama al repositorio para guardar la nueva película
            return iPeliculaRepository.save(peliculaModel);
        } catch (Exception e) {
            // Registra el error si la operación falla
            logger.error("Error al guardar la película: {}", e.getMessage());
            throw new RuntimeException("Error al guardar la película", e);
        }
    }

    /**
     * Actualiza los detalles de una película existente en la base de datos.
     *
     * @param peliculaModel El modelo de la película con los datos actualizados.
     * @return Número de filas afectadas (1 si la operación fue exitosa, 0 si no se encontró la película).
     */
    @Override
    public int update(PeliculaModel peliculaModel) {
        try {
            // Llama al repositorio para actualizar la película
            return iPeliculaRepository.update(peliculaModel);
        } catch (Exception e) {
            // Registra el error si la operación falla
            logger.error("Error al actualizar la película: {}", e.getMessage());
            throw new RuntimeException("Error al actualizar la película", e);
        }
    }

    /**
     * Elimina una película de la base de datos según su ID.
     *
     * @param id El ID de la película a eliminar.
     * @return Número de filas afectadas (1 si la operación fue exitosa, 0 si no se encontró la película).
     */
    @Override
    public int deleteById(int id) {
        try {
            // Llama al repositorio para eliminar la película por ID
            return iPeliculaRepository.deleteById(id);
        } catch (Exception e) {
            // Registra el error si la operación falla
            logger.error("Error al eliminar la película con ID {}: {}", id, e.getMessage());
            throw new RuntimeException("Error al eliminar la película", e);
        }
    }
    /**
     * Actualiza el estado del alquiler de una película.
     *
     * @param id El ID de la película.
     * @param estadoAlquiler El nuevo estado del alquiler ("Alquilado", "Disponible").
     * @return 1 si la operación fue exitosa, 0 si no se encuentra la película o hay error.
     */
    @Override
    public int updateEstadoAlquiler(int id, String estadoAlquiler) {
        try {
            // Llama al repositorio para actualizar el estado del alquiler
            int result = iPeliculaRepository.updateEstadoAlquiler(id, estadoAlquiler);

            if (result == 1) {
                logger.info("Estado del alquiler actualizado para la película con ID: {}", id);
            } else {
                logger.warn("No se encontró la película con ID: {}", id);
            }

            return result;
        } catch (Exception e) {
            // Registra el error si la operación falla
            logger.error("Error al actualizar el estado del alquiler de la película con ID {}: {}", id, e.getMessage());
            throw new RuntimeException("Error al actualizar el estado del alquiler", e);
        }
    }
}
