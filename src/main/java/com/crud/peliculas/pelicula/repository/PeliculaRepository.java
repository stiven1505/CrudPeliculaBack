package com.crud.peliculas.pelicula.repository;

import com.crud.peliculas.pelicula.model.PeliculaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;

/**
 * Repositorio que implementa las operaciones CRUD para la entidad PeliculaModel.
 * Utiliza JdbcTemplate para interactuar con la base de datos.
 */
@Repository
public class PeliculaRepository implements IPeliculaRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate; // Inyección de dependencia para interactuar con la base de datos

    /**
     * Obtiene todos los registros de películas de la base de datos.
     *
     * @return Lista de objetos PeliculaModel.
     */
    @Override
    public List<PeliculaModel> findAll() {
        try {
            String sql = "SELECT * FROM peliculas"; // Consulta SQL para obtener todos los registros
            return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(PeliculaModel.class)); // Mapeo automático
        } catch (Exception e) {
            e.printStackTrace(); // Imprime el error en consola
            return List.of(); // Devuelve una lista vacía en caso de error
        }
    }

    /**
     * Inserta una nueva película en la base de datos.
     *
     * @param peliculaModel El objeto PeliculaModel que contiene los datos de la película a guardar.
     * @return 1 si la operación fue exitosa, 0 en caso de error.
     */
    @Override
    public int save(PeliculaModel peliculaModel) {
        try {
            String sql = "INSERT INTO peliculas (nombre, cubierta, descripcion, puntaje, estado, estado_alquiler, fechaCreacion, fechaModificacion) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            // Ejecuta la inserción utilizando los valores del objeto PeliculaModel
            return jdbcTemplate.update(sql, new Object[]{
                    peliculaModel.getNombre(),
                    peliculaModel.getCubierta(),
                    peliculaModel.getDescripcion(),
                    peliculaModel.getPuntaje(),
                    peliculaModel.getEstado(),
                    peliculaModel.getEstadoAlquiler(),
                    peliculaModel.getFechaCreacion(),
                    peliculaModel.getFechaModificacion()
            });
        } catch (Exception e) {
            e.printStackTrace(); // Imprime el error en consola
            return 0; // Retorna 0 en caso de fallo
        }
    }

    /**
     * Actualiza una película existente en la base de datos.
     *
     * @param peliculaModel El objeto PeliculaModel que contiene los datos de la película a actualizar.
     * @return 1 si la operación fue exitosa, 0 si no se encuentra la película o hay error.
     */
    @Override
    public int update(PeliculaModel peliculaModel) {
        try {
            String sql = "UPDATE peliculas SET " +
                    "nombre = ?, " +
                    "cubierta = ?, " +
                    "descripcion = ?, " +
                    "puntaje = ?, " +
                    "estado = ?, " +
                    "estado_Alquiler = ?, " +
                    "fechaModificacion = ? " +
                    "WHERE id = ?";

            // Obtener la fecha y hora actuales del sistema
            LocalDateTime fechaActual = LocalDateTime.now();

            // Ejecuta la actualización con los nuevos valores
            return jdbcTemplate.update(sql, new Object[]{
                    peliculaModel.getNombre(),
                    peliculaModel.getCubierta(),
                    peliculaModel.getDescripcion(),
                    peliculaModel.getPuntaje(),
                    peliculaModel.getEstado(),
                    peliculaModel.getEstadoAlquiler(),
                    fechaActual, // Establecer la fecha actual del sistema
                    peliculaModel.getId() // El ID del registro a actualizar
            });
        } catch (Exception e) {
            e.printStackTrace(); // Imprime el error en consola
            return 0; // Retorna 0 en caso de fallo
        }
    }

    /**
     * Elimina una película de la base de datos según su ID.
     *
     * @param id El ID de la película a eliminar.
     * @return 1 si la operación fue exitosa, 0 si no se encuentra la película o hay error.
     */
    @Override
    public int deleteById(int id) {
        try {
            String sql = "DELETE FROM peliculas WHERE id = ?";
            return jdbcTemplate.update(sql, id); // Ejecuta la eliminación
        } catch (Exception e) {
            e.printStackTrace(); // Imprime el error en consola
            return 0; // Retorna 0 en caso de fallo
        }
    }

    /**
     * Actualiza solo el estado del alquiler de una película.
     *
     * @param id El ID de la película.
     * @param estadoAlquiler El nuevo estado del alquiler.
     * @return 1 si la operación fue exitosa, 0 si no se encuentra la película o hay error.
     */
    public int updateEstadoAlquiler(int id, String estadoAlquiler) {
        try {
            String sql = "UPDATE peliculas SET Estado_alquiler = ? WHERE id = ?";
            return jdbcTemplate.update(sql, estadoAlquiler, id);
        } catch (Exception e) {
            e.printStackTrace(); // Imprime el error en consola
            return 0; // Retorna 0 en caso de fallo
        }
    }

}
