package com.riwi.primeraweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.riwi.primeraweb.entity.Coder;
import com.riwi.primeraweb.repository.CoderRepository;

@Service
public class CoderService {

    // Registra la inyeccion de dependencias en SpringBoot
    @Autowired
    private CoderRepository objCoderRepository;

    public List<Coder> findAll() {

        return this.objCoderRepository.findAll();
    }

    public Page<Coder> findAllPaginate(int page, int size){
        //Validar que la pagina no sea menor a 0
        if (page < 0) {
            page = 0;
        }
        //Creamos la paginacion
        Pageable objPage = PageRequest.of(page, size);
        // Retornamos una lista paginada de Coder
        return this.objCoderRepository.findAll(objPage);
    }

    // Metodo para crear un nuevo Coder, se hace uso del repositorio y del metodo
    // Save, el cual se encarga de insertar
    public Coder create(Coder objCoder) {
        return this.objCoderRepository.save(objCoder);
    }

    // Metodo para eliminar un Coder (deleteById)
    public void delete(Long id) {
        // lamar al repositorio
        this.objCoderRepository.deleteById(id);
    }

    // Metodo para obtener por ID un Coder
    public Coder findCoderById(Long id) {
        // Busca en un Coder por ID y si no lo encuentra retorna null, si lo encuentra
        // retorna un objeto, una instancia de Coder
        return this.objCoderRepository.findById(id).orElse(null);
    }

    //Metodo para actualizar un Coder
    public Coder updateCoder(Long id, Coder coder){

        //1.Buscar coder por ID
        Coder objCoderDB = this.findCoderById(id);
        //2. Verificamos que el coder existe
        if (objCoderDB == null) return null;
        //3. Actualizamos el Coder Antiguo
        objCoderDB = coder;
        //4. Retornamos el Coder con el metodo save que verifica si la llave primaria llega llena
        // y depende eso, actualiza o crea
        return this.objCoderRepository.save(objCoderDB);
    }
}
