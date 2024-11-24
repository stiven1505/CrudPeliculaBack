package com.crud.peliculas.pelicula.repository;

import com.crud.peliculas.pelicula.model.PeliculaModel;
import java.util.List;

/**
 * Interfaz para definir las operaciones CRUD (Crear, Leer, Actualizar, Eliminar)
 * sobre la entidad PeliculaModel.
 *
 * Esta interfaz es implementada por el repositorio que interactúa con la base de datos.
 */
public interface IPeliculaRepository {

    /**
     * Obtiene una lista de todas las películas almacenadas en la base de datos.
     *
     * @return Una lista de objetos PeliculaModel que representan las películas en la base de datos.
     */
    public List<PeliculaModel> findAll();

    /**
     * Guarda una nueva película en la base de datos.
     *
     * @param peliculaModel El objeto PeliculaModel que contiene los datos de la película a guardar.
     * @return Un valor entero (1 si la operación fue exitosa, 0 si hubo un error).
     */
    public int save(PeliculaModel peliculaModel);

    /**
     * Actualiza los datos de una película existente en la base de datos.
     *
     * @param peliculaModel El objeto PeliculaModel con los nuevos datos de la película a actualizar.
     * @return Un valor entero (1 si la operación fue exitosa, 0 si la película no fue encontrada).
     */
    public int update(PeliculaModel peliculaModel);

    /**
     * Elimina una película de la base de datos utilizando su ID.
     *
     * @param id El ID de la película a eliminar.
     * @return Un valor entero (1 si la operación fue exitosa, 0 si la película no fue encontrada).
     */
    public int deleteById(int id);

     /**
     * Actualiza el estado del alquiler de una película.
     *
     * @param id El ID de la película.
     * @param estadoAlquiler El nuevo estado del alquiler ("Alquilado", "Disponible").
     * @return 1 si la operación fue exitosa, 0 si no se encuentra la película o hay error.
     */
    public int updateEstadoAlquiler(int id, String estadoAlquiler);
}
