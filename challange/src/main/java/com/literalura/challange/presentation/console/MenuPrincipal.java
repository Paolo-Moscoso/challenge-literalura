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

        int opcion = -1;

        while (opcion != 0) {

            System.out.println("""
                    
                    1 - Buscar libro por título
                    0 - Salir
                    
                    """);

            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {

                case 1:
                    buscarLibro();
                    break;

                case 0:
                    System.out.println("Cerrando aplicación");
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

    private void listarLibros(){

        System.out.println("Lista de Libros");
        var libros = libroService.listarLibros();

        libros.forEach(l ->
            System.out.println(l.getTitulo()));
    }

}