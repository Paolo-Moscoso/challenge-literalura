package com.literalura.challange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.literalura.challange.presentation.console.MenuPrincipal;

@SpringBootApplication
public class ChallangeApplication implements CommandLineRunner {

	@Autowired
    private MenuPrincipal menu;

    public static void main(String[] args) {
        SpringApplication.run(LiteraluraApplication.class, args);
    }

    @Override
    public void run(String... args) {
        menu.mostrarMenu();
    }
}
