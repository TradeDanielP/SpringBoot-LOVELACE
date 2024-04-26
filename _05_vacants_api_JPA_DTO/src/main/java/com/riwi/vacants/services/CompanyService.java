package com.riwi.vacants.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.riwi.vacants.entities.Company;
import com.riwi.vacants.repositories.CompanyRepository;
import com.riwi.vacants.services.interfaces.ICompanyService;
import com.riwi.vacants.utils.dto.request.CompanyRequest;
import com.riwi.vacants.utils.dto.response.CompanyResponse;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CompanyService implements ICompanyService {

    @Autowired
    private final CompanyRepository objRepository;

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public CompanyResponse create(CompanyRequest request) {
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public CompanyResponse update(String ID, CompanyRequest Request) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
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

    // Este metodo se encarga de cpnvertir un objeto Company a CompanyResponse
    private CompanyResponse entityToResponse(Company entity){
        CompanyResponse response = new CompanyResponse();
        BeanUtils.copyProperties(entity, response);
        return response;
    }
    


}
