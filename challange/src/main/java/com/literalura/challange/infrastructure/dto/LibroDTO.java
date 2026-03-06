package com.literalura.challange.infrastructure.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public record LibroDTO(

        @JsonAlias("title")
        String titulo,

        @JsonAlias("languages")
        List<String> idiomas,

        @JsonAlias("download_count")
        Integer descargas,

        @JsonAlias("authors")
        List<AutorDTO> autores
) {
}