package com.literalura.challange.domain.repository;

import com.literalura.challange.domain.model.Autor;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    Optional<Autor> findByNombreIgnoreCase(String nombre);

    @Query("""
        SELECT a FROM Autor a
        WHERE a.nacimiento <= :anio
        AND (a.fallecimiento >= :anio OR a.fallecimiento IS NULL)
    """)
    List<Autor> autoresVivos(@Param("anio") int anio);

}