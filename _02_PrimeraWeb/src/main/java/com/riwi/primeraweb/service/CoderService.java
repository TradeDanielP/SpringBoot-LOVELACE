package com.riwi.primeraweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riwi.primeraweb.entity.Coder;
import com.riwi.primeraweb.repository.CoderRepository;

@Service
public class CoderService {

    // Registra la inyeccion de dependencias en SpringBoot
    @Autowired
    private CoderRepository objCoderRepository;
    
    public List<Coder> findAll(){

        return this.objCoderRepository.findAll();
    }

    //Metodo para crear un nuevo Coder, se hace uso del repositorio y del metodo Save, el cual se encarga de insertar
    public Coder create(Coder objCoder){
        return this.objCoderRepository.save(objCoder);
    }
}
