package com.riwi.vacants.utils.exceptions;

// RuntimeException es la clase general de errores en Java, la utilizaremos para implementar su constructor en esta clase y generar el error personalizado
public class IdNotFoundException extends RuntimeException {

    private static final String ERROR_MESSAGE = "No hay registro en la entidad %s con el id suministrado";
    
    //Utilizamos el constructor de RunTimeException y enviamos el mensaje inyectando el nombre de la entidad
    public IdNotFoundException(String nameEntity){
        super(String.format(ERROR_MESSAGE,nameEntity));
    }
}
