package com.literalura.challange.domain.repository;

import com.literalura.challange.domain.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    List<Libro> findByIdioma(String idioma);

    Optional<Libro> findByTituloIgnoreCase(String titulo);
    
}