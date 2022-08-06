package org.example.tierheim;

import org.example.tierheim.mitarbeiter.application.CreateMitarbeiterUseCase;
import org.example.tierheim.mitarbeiter.application.MitarbeiterChanges;
import org.example.tierheim.mitarbeiter.application.ReadMitarbeiterUseCase;
import org.example.tierheim.shared.Name;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private CreateMitarbeiterUseCase create;

    @Autowired
    private ReadMitarbeiterUseCase read;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(final String... args) throws Exception {
        System.out.println("Before: " + read.findAll());
        System.out.println("Created: " + create.execute(MitarbeiterChanges.builder().name(Name.of("Max")).build()));
        System.out.println("After: " + read.findAll());
    }

}
