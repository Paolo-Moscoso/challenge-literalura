package com.literalura.challange.infrastructure.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true) // <--- Ignora campos no definidos en el record
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