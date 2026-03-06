package com.literalura.challange.infrastructure.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public record RespuestaGutendexDTO(

        @JsonAlias("results")
        List<LibroDTO> resultados
) {
}