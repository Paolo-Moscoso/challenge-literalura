package com.literalura.challange.presentation.console;

import org.springframework.stereotype.Component;

import com.literalura.challange.application.service.LibroService;

import java.util.Scanner;

@Component
public class MenuPrincipal {

    private Scanner teclado = new Scanner(System.in);

    private LibroService libroService;

    public MenuPrincipal(LibroService libroService) {
        this.libroService = libroService;
    }

    public void mostrarMenu() {

        var opcion = -1;

        while (opcion != 0) {

            var menu = """

                    -----------------
                    Ingresar una opción:
                    1 - Buscar libro por título
                    2 - Listar libros registrados
                    3 - Listar autores registrados
                    4 - Listar autores vivos en un determinado año
                    5 - Listar libros por idioma
                    0 - Salir
                    """;

            System.out.println(menu);

            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {

                case 1:
                    buscarLibroPorTitulo();
                    break;

                case 2:
                    listarLibros();
                    break;

                case 3:
                    listarAutores();
                    break;

                case 4:
                    listarAutoresVivos();
                    break;

                case 5:
                    listarLibrosPorIdioma();
                    break;

                case 0:
                    System.out.println("Cerrando aplicación...");
                    break;

                default:
                    System.out.println("Opción inválida");
            }
        }
    }

    private void buscarLibro() {

        System.out.println("Escribe el nombre del libro:");

        String titulo = teclado.nextLine();

        var libro = libroService.buscarLibroPorTitulo(titulo);

        if (libro != null) {
            System.out.println("Libro guardado:");
            System.out.println(libro.getTitulo());
        }

    }

    private void listarLibros() {

        System.out.println("Lista de Libros");
        var libros = libroService.listarLibros();
        libros.forEach(libro -> {

            System.out.println("""
                    -------------------------------
                    Libro
                    Título: %s
                    Autor: %s
                    Idioma: %s
                    Descargas: %d
                    -------------------------------
                    """.formatted(
                    libro.getTitulo(),
                    libro.getAutor().getNombre(),
                    libro.getIdioma(),
                    libro.getDescargas()));

        });

    }

    private void buscarLibroPorTitulo() {

        System.out.println("Escribe el nombre del libro:");

        var titulo = teclado.nextLine();

        var libro = libroService.buscarLibroPorTitulo(titulo);

        if (libro != null) {

            System.out.println("Libro encontrado:");

            System.out.println("Título: " + libro.getTitulo());
            System.out.println("Autor: " + libro.getAutor().getNombre());
            System.out.println("Idioma: " + libro.getIdioma());
            System.out.println("Descargas: " + libro.getDescargas());
        }

    }

    private void listarLibros() {

        var libros = libroService.listarLibros();

        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados");
            return;
        }

        libros.forEach(libro -> {

            System.out.println("------------");
            System.out.println("Título: " + libro.getTitulo());
            System.out.println("Autor: " + libro.getAutor().getNombre());
            System.out.println("Idioma: " + libro.getIdioma());
            System.out.println("Descargas: " + libro.getDescargas());

        });
    }

    private void listarAutores() {

        var autores = libroService.listarAutores();

        if (autores.isEmpty()) {
            System.out.println("No hay autores registrados");
            return;
        }

        autores.forEach(autor -> {

            System.out.println("------------");
            System.out.println("Autor: " + autor.getNombre());
            System.out.println("Nacimiento: " + autor.getNacimiento());
            System.out.println("Fallecimiento: " + autor.getFallecimiento());

        });
    }

    private void listarAutoresVivos() {

        System.out.println("Ingrese el año:");

        var anio = teclado.nextInt();
        teclado.nextLine();

        var autores = libroService.autoresVivosEnAnio(anio);

        autores.forEach(autor -> {

            System.out.println("------------");
            System.out.println("Autor: " + autor.getNombre());
            System.out.println("Nacimiento: " + autor.getNacimiento());
            System.out.println("Fallecimiento: " + autor.getFallecimiento());

        });
    }

    private void listarLibrosPorIdioma() {

        System.out.println("""
                Ingrese idioma:
                es - Español
                en - Inglés
                fr - Francés
                pt - Portugués
                """);

        var idioma = teclado.nextLine();

        var libros = libroService.buscarPorIdioma(idioma);

        libros.forEach(libro -> {

            System.out.println("------------");
            System.out.println("Título: " + libro.getTitulo());
            System.out.println("Autor: " + libro.getAutor().getNombre());
            System.out.println("Idioma: " + libro.getIdioma());

        });
    }

}