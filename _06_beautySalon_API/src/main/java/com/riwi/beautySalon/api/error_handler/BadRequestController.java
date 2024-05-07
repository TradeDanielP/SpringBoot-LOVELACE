package com.riwi.beautySalon.api.error_handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.riwi.beautySalon.api.dto.errors.BaseErrorResp;
import com.riwi.beautySalon.api.dto.errors.ErrorsResp;

//Controlador de errores
@RestControllerAdvice
//Status de error del controlador
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BadRequestController {
    
    //MethodArgumentNotValidException es la excepcion que activa la libreria de validacion
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseErrorResp handleBadRequest(MethodArgumentNotValidException exception){

        List<Map<String,String>> errors = new ArrayList<>();

        //getBindingResult obtiene los resultados con el fiel y el error
        //getFieldErrors obtiene la lista de los nombres del campo error
        exception.getBindingResult().getFieldErrors().forEach(e -> {
            Map<String,String> error = new HashMap<>();
            error.put("error",e.getDefaultMessage()); //agregar al map de error
            error.put("field",e.getField()); //agregar al map donde ocurrio el error
            errors.add(error);
        });

        return ErrorsResp.builder()
                    .code(HttpStatus.BAD_REQUEST.value())
                    .status(HttpStatus.BAD_REQUEST.name())
                    .errors(errors)
                    .build();
    }

}
