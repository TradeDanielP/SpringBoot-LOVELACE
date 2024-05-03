package com.riwi.vacants.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.vacants.services.CompanyService;
import com.riwi.vacants.utils.dto.errors.ErrorResponse;
import com.riwi.vacants.utils.dto.request.CompanyRequest;
import com.riwi.vacants.utils.dto.response.CompanyResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/company")
@AllArgsConstructor
//con tag podemos cambiar el nombre en swagger
@Tag(name = "Compañias")
public class CompanyController {

    @Autowired
    private final CompanyService objService;

    //Nos ayuda a crear nuevo esquema de respuesta
    @ApiResponse(
        responseCode = "400",
        description = "Cuando el id no es valida",
        content = {
            @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = ErrorResponse.class)
            )
        }
    )
    @Operation(
        summary = "Lista todas las vacantes con paginacion",
        description = "Debes enviar la pagina y el tamaño de la pagina para recibir todas las vacantes correspondientes"
    )
    @GetMapping
    public ResponseEntity<Page<CompanyResponse>> get(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "2") int size) {

        return ResponseEntity.ok(this.objService.getAll(page - 1, size));
    }

    @Operation(
        summary = "Lista una vacante con paginacion",
        description = "Debes enviar el ID de la vacante a buscar"
    )
    @GetMapping(path = "/{id}")
    public ResponseEntity<CompanyResponse> getById(
            @PathVariable String id) {
        return ResponseEntity.ok(this.objService.getById(id));
    }

    @Operation(
        summary = "Crea una vacante y la asocia a una compañia",
        description = "Crea una vacante y la asocia a una compañia"
    )
    @PostMapping
    public ResponseEntity<CompanyResponse> insert(
           @Validated @RequestBody CompanyRequest company) {
        return ResponseEntity.ok(this.objService.create(company));
    }

    @Operation(
        summary = "Elimina una vacante por ID",
        description = "Elimina una vacante por ID"
    )
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        this.objService.delete(id);
        ;
        return ResponseEntity.noContent().build();
    }

    @Operation(
        summary = "Actualiza una vacante por ID",
        description = "Actualiza una vacante por ID"
    )
    @PutMapping(path = "/{id}")
    public ResponseEntity<CompanyResponse> update(@PathVariable String id,@Validated @RequestBody CompanyRequest company){
        return ResponseEntity.ok(this.objService.update(id, company));
    }

}
