package com.crud.peliculas.pelicula.service;

import com.crud.peliculas.pelicula.model.PeliculaModel;

import java.util.List;

/**
 * Interfaz que define los métodos del servicio para gestionar las operaciones CRUD sobre las películas.
 * Los métodos son implementados por la clase PeliculaService.
 */
public interface IPeliculaService {

    /**
     * Obtiene una lista de todas las películas.
     *
     * @return Lista de objetos PeliculaModel que representan las películas almacenadas.
     */
    public List<PeliculaModel> findAll();

    /**
     * Guarda una nueva película en la base de datos.
     *
     * @param pelicula Objeto PeliculaModel que contiene los datos de la película a guardar.
     * @return Número de filas afectadas por la operación (1 si se guardó correctamente, 0 si hubo un error).
     */
    public int save(PeliculaModel pelicula);

    /**
     * Actualiza los datos de una película existente en la base de datos.
     *
     * @param pelicula Objeto PeliculaModel que contiene los datos actualizados de la película.
     * @return Número de filas afectadas por la operación (1 si se actualizó correctamente, 0 si no se encontró la película).
     */
    public int update(PeliculaModel pelicula);

    /**
     * Elimina una película de la base de datos utilizando su ID.
     *
     * @param id El ID de la película a eliminar.
     * @return Número de filas afectadas por la operación (1 si se eliminó correctamente, 0 si no se encontró la película).
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
