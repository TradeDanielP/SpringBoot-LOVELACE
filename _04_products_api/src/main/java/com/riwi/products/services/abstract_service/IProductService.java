package com.riwi.products.services.abstract_service;

import java.util.List;
import com.riwi.products.entities.Product;

/* Utilizamos una interface para ser utilizada como inyeccion de dependecias en controlador, mantiene integridad, desacoplamiento y principios SOLID */

public interface IProductService {
    
    public Product save(Product objProduct);
    
    public List<Product> getAll();

    public Product getById(Long id);

    public boolean delete(Long id);

    public Product update(Product objProduct);

}
