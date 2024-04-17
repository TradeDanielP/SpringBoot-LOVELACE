package com.riwi.primeraweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.primeraweb.entity.Coder;

//El repositorio se encarga de establecer o manipular toda la persistencia de los datos, interactua directamente con la base de datos
@Repository
// Extendemos de la interface de JPA para obtener todos los metodos del CRUD
public interface CoderRepository extends JpaRepository<Coder, Long>{

    

}
