package com.crud.peliculas.pelicula.model;

import lombok.Data;
import java.time.LocalDate;

/**
 * Clase que representa el modelo de datos de una película.
 * Esta clase contiene los atributos y comportamientos relacionados con la película,
 * y es usada para mapear los datos entre la base de datos y la capa de servicio.
 */
@Data // Lombok generará automáticamente los getters, setters, toString(), equals() y hashCode()
public class PeliculaModel {

    // Identificador único de la película
    private Long id;

    // Nombre de la película
    private String nombre;

    // URL de la cubierta de la película
    private String cubierta;

    // Descripción de la película
    private String descripcion;

    // Puntaje de la película (por ejemplo, de 1 a 10)
    private Integer puntaje;

    // Estado de la película ( "disponible", "edicion")
    private String estado;

    // Estado del alquiler ( "alquiler", "disponible",)
    private String estadoAlquiler;

    // Fecha de creación de la película
    private LocalDate fechaCreacion;

    // Fecha de la última modificación de la película
    private LocalDate fechaModificacion;

    /**
     * Constructor predeterminado de la clase PeliculaModel.
     * Lombok genera un constructor por defecto, pero si necesitas uno personalizado
     * o con parámetros, puedes agregarlo aquí.
     */

    public PeliculaModel() {
        // Constructor vacío generado por defecto por Lombok
    }

    /**
     * Método que se invoca al usar @Data, genera el getter y setter para cada propiedad
     * de la clase. Los datos de la película serán accesibles y modificables a través de estos métodos.
     */
}
