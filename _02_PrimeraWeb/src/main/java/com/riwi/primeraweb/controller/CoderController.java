package com.riwi.primeraweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.riwi.primeraweb.entity.Coder;
import com.riwi.primeraweb.service.CoderService;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
//Crear la ruta donde se activara este controlador
@RequestMapping("/")
public class CoderController {
    // Establecer la inyeccion de dependencias
    @Autowired
    private CoderService objCoderService;

    //Metodo para mostrar la vista y enviarle toda la lista de Coders
    @GetMapping()
    public String showViewCoder(Model objModel){

        //Obtenemos la lista de COders
        List<Coder> listCoders = this.objCoderService.findAll();

        //Cargamos la lista en modelo}
        objModel.addAttribute("listCoders", listCoders); //Llave - Valor

        return "viewCoders";
    }

    @GetMapping("/form")
    public String showViewForm(){

        return "viewForm";
    }

    //Metodo para recibir toda la informacion del Formulario
    //MOdelAttribute para recibir informacion de la vista
    @PostMapping("create-coder")
    public String createCoder(@ModelAttribute Coder objCoder){

        this.objCoderService.create(objCoder);

        return "redirect:/";
    }

    //Metodo para mostrar la vista de formulario y ademas enviar una instancia de Coder vacia
    @PostMapping("form")
    public String showViewForm(Model model){

        model.addAttribute("coder", new Coder());
        model.addAttribute("action", "/create-coder");

        return "viewForm";
    }

}
