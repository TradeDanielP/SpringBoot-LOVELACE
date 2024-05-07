package com.riwi.beautySalon.api.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientReq {
    
     @NotBlank(message = "El nombre es requerido")
    @Size(
        min = 1,
        max = 100,
        message = "El nombre debe tener entre 1 y 100 caracteres"
    )
    private String firstName;
    @NotBlank(message = "El apellido es requerido")
    @Size(
        min = 1,
        max = 100,
        message = "El apellido debe tener entre 1 y 100 caracteres"
    )
    private String lastName;
    @Size(
        min = 1,
        max = 100,
        message = "El email debe tener entre 1 y 100 caracteres"
    )
    @Email
    private String email;
    @NotBlank(message = "El telefono es requerido")
    @Size(
        min = 10,
        max = 20,
        message = "El telefono debe tener entre 10 y 20 caracteres"
    )
    private String phone;

}
