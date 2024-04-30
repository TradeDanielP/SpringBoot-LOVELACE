package com.riwi.vacants.services;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.vacants.entities.Company;
import com.riwi.vacants.entities.Vacant;
import com.riwi.vacants.repositories.CompanyRepository;
import com.riwi.vacants.services.interfaces.ICompanyService;
import com.riwi.vacants.utils.dto.request.CompanyRequest;
import com.riwi.vacants.utils.dto.response.CompanyResponse;
import com.riwi.vacants.utils.dto.response.VacantToCompanyResponse;
import com.riwi.vacants.utils.exceptions.IdNotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CompanyService implements ICompanyService {

    @Autowired
    private final CompanyRepository objRepository;

    @Override
    public void delete(String id) {
        Company company = this.find(id);
        this.objRepository.delete(company);
    }

    @Override
    public CompanyResponse create(CompanyRequest request) {
        Company company = this.requestToCompany(request, new Company());

        return this.entityToResponse(this.objRepository.save(company));
    }

    @Override
    public CompanyResponse update(String ID, CompanyRequest Request) {
        // Buscamos la compañia con el id
        Company company = this.find(ID);
        // Llenamos la compañia con los nuevos datos a la vez que lo convertimos
        Company companyUpdate = this.requestToCompany(Request, company);
        // Guardamos la compañia actualizada y convertimos a la respuesta
        return this.entityToResponse(this.objRepository.save(companyUpdate));
    }

    @Override
    public Page<CompanyResponse> getAll(int page, int size) {
        if (page < 0) page = 0;
        PageRequest pagination = PageRequest.of(page,size);

        /* return this.objRepository.findAll(pagination)
            .map(company->this.entityToResponse(company)); */

            //Iteramos con map cada compañia y la convertimos, se puede con expresion lambda flecha -> o expresion lambda diferencial ::
        return this.objRepository.findAll(pagination)
            .map(this::entityToResponse);
    }

    @Override
    public CompanyResponse getById(String id){
        return this.entityToResponse(this.find(id));
    }

    private Company find(String id){
        return this.objRepository.findById(id).orElseThrow(()-> 
            new IdNotFoundException("Company"));
    }

    // Este metodo se encarga de cpnvertir un objeto Company a CompanyResponse
    private CompanyResponse entityToResponse(Company entity){
        CompanyResponse response = new CompanyResponse();
        BeanUtils.copyProperties(entity, response);

        //Mapeamos las vacantes convirtiendo cada una de ellas al dto de respuesta 
        // stream() convirte una lista en una coleccion para poder acceder
        //
        response.setVacants(entity.getVacants().stream().map(this::vacantToResponse).collect(Collectors.toList()));
        return response;
    }
    
    private VacantToCompanyResponse vacantToResponse(Vacant entity){
            VacantToCompanyResponse response = new VacantToCompanyResponse();

            BeanUtils.copyProperties(entity, response);

            return response;
    }

    private Company requestToCompany(CompanyRequest request, Company company){
        //Hacemos la copia
        BeanUtils.copyProperties(request, company);

        company.setVacants(new ArrayList<>());

        return company;
    }


}
