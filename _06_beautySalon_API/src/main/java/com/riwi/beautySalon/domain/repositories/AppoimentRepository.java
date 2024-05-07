package com.riwi.beautySalon.domain.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.riwi.beautySalon.domain.entities.Appoiment;

@Repository
public interface AppoimentRepository 
    extends JpaRepository<Appoiment, Long>{
   
    @Query(value = "select a from appoiment a join fetch a.client c where c.id = :idClient")
    Optional<Appoiment> findByClientId(Long idClient);

}
