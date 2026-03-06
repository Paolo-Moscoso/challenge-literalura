package com.literalura.challange.domain.repository;

import com.literalura.domain.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    @Query("SELECT a FROM Autor a WHERE a.nacimiento <= :anio AND (a.fallecimiento >= :anio OR a.fallecimiento IS NULL)")
    List<Autor> autoresVivos(@Param("anio") int anio);

}