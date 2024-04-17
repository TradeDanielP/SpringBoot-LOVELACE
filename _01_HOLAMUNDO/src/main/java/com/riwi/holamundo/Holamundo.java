package com.riwi.holamundo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//Indica que esta clase será un controlador
@Controller
// Request Mapping crea la ruta base para acceder al controlador
@RequestMapping("/controller")
public class Holamundo {
    
    // GetMapping crea la ruta especifica donde se disparara el metodo
    @GetMapping("/saludar")
    //ResponseBody, permite responder en formato texto o json
    @ResponseBody()
    public String mostrarMensaje(){

        return "<h1 style='color:blue;text-align:center;font-size:150px'>Hola Mundo</h1> <p style='text-align:center;font-size:40px;'>Este es mi primer codigo desde Spring Boot</p>";
    }
}
