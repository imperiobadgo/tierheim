package org.example.tierheim;

import org.example.tierheim.mitarbeiter.application.CreateMitarbeiterUseCase;
import org.example.tierheim.mitarbeiter.application.ReadMitarbeiterUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

//    @Autowired
//    private CreateMitarbeiterUseCase create;
//
//    @Autowired
//    private ReadMitarbeiterUseCase read;

    //http://localhost:8080/h2-console
    @Override
    public void run(final String... args) throws Exception {
//        System.out.println("Before: " + read.findAll());
//        System.out.println("Created: " + create.execute(MitarbeiterChanges.builder().name(Name.of("Max")).build()));
//        System.out.println("After: " + read.findAll());
    }

}
