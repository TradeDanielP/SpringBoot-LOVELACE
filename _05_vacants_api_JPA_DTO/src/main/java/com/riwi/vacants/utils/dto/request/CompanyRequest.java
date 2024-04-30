package com.riwi.vacants.utils.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder //Patron de diseño para creacion de clases
@AllArgsConstructor
@NoArgsConstructor
public class CompanyRequest {

    @Size(min = 0, max = 40, message = "El nombre supera la cantidad de caracteres permitidos")
    @NotBlank(message = "El nombre de la compañia es requerido")
    private String name;
    @NotBlank(message = "La locacion de la compañia es requerida")
    private String location;
    @Size(min = 0, max = 14, message = "El contacto supera la cantidad de caracteres permitidos")
    @NotBlank(message = "el contacto de la compañia es requerida")
    private String contact;
    
}
