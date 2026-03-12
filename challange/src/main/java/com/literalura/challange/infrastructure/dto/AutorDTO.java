package com.literalura.challange.infrastructure.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) // Ignora campos extra en JSON
public record AutorDTO(
        @JsonAlias("name")
        String nombre,

        @JsonAlias("birth_year")
        Integer nacimiento,

        @JsonAlias("death_year")
        Integer fallecimiento
) {}