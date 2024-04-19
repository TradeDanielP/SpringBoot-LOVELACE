package com.riwi.primeraweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.riwi.primeraweb.entity.Coder;
import com.riwi.primeraweb.service.CoderService;

@Controller
// Crear la ruta donde se activara este controlador
@RequestMapping("/")
public class CoderController {
    // Establecer la inyeccion de dependencias
    @Autowired
    private CoderService objCoderService;

    // Metodo para mostrar la vista y enviarle toda la lista de Coders
    @GetMapping()
    public String showViewCoder(
            Model objModel,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "2") int size) {

        // Obtenemos la lista de COders
        Page<Coder> listCoders = this.objCoderService.findAllPaginate(page - 1,size);

        // Cargamos la lista en modelo}
        objModel.addAttribute("listCoders", listCoders); // Llave - Valor
        objModel.addAttribute("currentPage", page);
        objModel.addAttribute("totalPage", listCoders.getTotalPages());

        return "viewCoders";
    }

    // Metodo para enviar el Objeto vacio para despues ser llenado por la accion del
    // form
    // Get Mapping es para mostrar las vistas
    @GetMapping("/form")
    public String showViewForm(Model model) {
        model.addAttribute("coder", new Coder());
        model.addAttribute("action", "/create-coder");
        return "viewForm";
    }

    // Metodo para recibir toda la informacion del Formulario
    // MOdelAttribute para recibir informacion de la vista
    @PostMapping("create-coder")
    public String createCoder(@ModelAttribute Coder objCoder) {
        this.objCoderService.create(objCoder);

        return "redirect:/";
    }

    // Controlador para eliminar recibira como parametro el id por URL
    // PathVariable funciona para obtener el valor de una variable de una url, solo
    // si es de tipo path (ejm: /delete/10)
    // donde el 10 es dinamico
    @GetMapping("/delete/{id}")
    public String deleteCoder(@PathVariable Long id) {
        this.objCoderService.delete(id);

        // Redireccionar a la lista de coders
        return "redirect:/";
    }

    // Controlador para mostrar el formulario con la informacion rellenada
    @GetMapping("/update/{id}")
    public String updateCoder(@PathVariable Long id, Model model) {
        Coder objCoder = this.objCoderService.findCoderById(id);

        model.addAttribute("coder", objCoder);
        model.addAttribute("action", "/edit/" + id);

        return "viewForm";
    }

    @PostMapping("edit/{id}")
    public String updateCoder(@PathVariable Long id, @ModelAttribute Coder objCoder) {
        this.objCoderService.updateCoder(id, objCoder);
        return "redirect:/";
    }

}
