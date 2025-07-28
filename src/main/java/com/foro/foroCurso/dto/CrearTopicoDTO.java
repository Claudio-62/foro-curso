package com.foro.foroCurso.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CrearTopicoDTO(
    @NotBlank(message = "El título es obligatorio") String titulo,
    @NotBlank(message = "El mensaje es obligatorio") String mensaje,
    @NotNull(message = "El autor es obligatorio") Long autorId
) {}