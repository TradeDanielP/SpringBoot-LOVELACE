package com.riwi.beautySalon.api.dto.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppoimentReq {
    
    @FutureOrPresent
    @NotBlank(message = "La fecha y hora de la cita es requerida")
    private LocalDateTime dateTime;
    @NotNull(message = "la duracion es requerida")
    @Min(value = 5)
    @Max(value = 760)
    private Integer duration;
    private String comments;
    @NotNull(message = "El id del cliente es obligatorio")
    @Min(value = 1)
    private Long clientId;
    @NotNull(message = "El id del Servicio es obligatorio")
    @Min(value = 1)
    private long serviceId;
    @NotNull(message = "El id del Empleado es obligatorio")
    @Min(value = 1)
    private Long employeeId;


}
