package com.crud.peliculas.pelicula.model;

import lombok.Data;

/**
 * Clase que representa la respuesta de un servicio.
 * Esta clase se utiliza para enviar una respuesta estandarizada desde los controladores
 * y servicios hacia el cliente, indicando si la operación fue exitosa o no, junto con un mensaje.
 */
@Data // Lombok generará automáticamente los getters, setters, toString(), equals() y hashCode()
public class ServiceResponse {

    // Indicador de si la operación fue exitosa
    private Boolean success;

    // Mensaje asociado con la operación (puede ser un mensaje de error o éxito)
    private String message;

    /**
     * Constructor por defecto, que Lombok generará automáticamente.
     * Si se desea crear un constructor personalizado, también se puede hacer.
     */

    public ServiceResponse() {
        // Constructor vacío generado automáticamente por Lombok
    }

    /**
     * Constructor personalizado para facilitar la creación de instancias con parámetros.
     *
     * @param success Indica si la operación fue exitosa.
     * @param message Mensaje relacionado con el resultado de la operación.
     */
    public ServiceResponse(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

}
