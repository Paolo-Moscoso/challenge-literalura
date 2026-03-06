package com.literalura.challange.application.service;

import com.literalura.challange.domain.model.Autor;
import com.literalura.challange.domain.model.Libro;
import com.literalura.challange.domain.repository.AutorRepository;
import com.literalura.challange.domain.repository.LibroRepository;
import com.literalura.challange.infrastructure.api.ConsumoApi;
import com.literalura.challange.infrastructure.api.ConvierteDatos;
import com.literalura.challange.infrastructure.dto.LibroDTO;
import com.literalura.challange.infrastructure.dto.RespuestaGutendexDTO;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    private final String URL_BASE = "https://gutendex.com/books/?search=";

    private ConsumoApi consumoApi = new ConsumoApi();
    private ConvierteDatos convierteDatos = new ConvierteDatos();

    private LibroRepository libroRepository;
    private AutorRepository autorRepository;

    public LibroService(LibroRepository libroRepository, AutorRepository autorRepository) {
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;
    }

    public Libro buscarLibroPorTitulo(String titulo) {

        var libroExistente = libroRepository.findByTituloIgnoreCase(titulo);

        if (libroExistente.isPresent()) {
            System.out.println("El libro ya está registrado en la base de datos.");
            return libroExistente.get();
        }

        String url = URL_BASE + titulo.replace(" ", "+");

        String json = consumoApi.obtenerDatos(url);

        RespuestaGutendexDTO datos = convierteDatos.obtenerDatos(json, RespuestaGutendexDTO.class);

        if (datos.resultados().isEmpty()) {
            System.out.println("Libro no encontrado");
            return null;
        }

        LibroDTO libroDTO = datos.resultados().get(0);

        Autor autor = new Autor();
        autor.setNombre(libroDTO.autores().get(0).nombre());
        autor.setNacimiento(libroDTO.autores().get(0).nacimiento());
        autor.setFallecimiento(libroDTO.autores().get(0).fallecimiento());

        Optional<Autor> autorExistente = autorRepository
                .findAll()
                .stream()
                .filter(a -> a.getNombre().equalsIgnoreCase(autor.getNombre()))
                .findFirst();

        if (autorExistente.isPresent()) {
            autor = autorExistente.get();
        } else {
            autorRepository.save(autor);
        }

        Libro libro = new Libro();
        libro.setTitulo(libroDTO.titulo());
        libro.setIdioma(libroDTO.idiomas().get(0));
        libro.setDescargas(libroDTO.descargas());
        libro.setAutor(autor);

        return libroRepository.save(libro);
    }

    public List<Libro> listarLibros() {
        return libroRepository.findAll();
    }

    public List<Autor> listarAutores() {
        return autorRepository.findAll();
    }

    public List<Libro> buscarPorIdioma(String idioma) {
        return libroRepository.findByIdioma(idioma);
    }

    public List<Autor> autoresVivosEnAnio(int anio) {
        return autorRepository.autoresVivos(anio);
    }

}