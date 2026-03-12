package com.literalura.challange.infrastructure.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true) // Ignora campos extra en JSON
public record RespuestaGutendexDTO(
        @JsonAlias("results")
        List<LibroDTO> resultados
) {}