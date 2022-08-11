package org.example.tierheim.mitarbeiter.application;

import org.example.tierheim.mitarbeiter.Mitarbeiter;
import org.example.tierheim.mitarbeiter.MitarbeiterId;

import java.util.List;

public interface ReadMitarbeiterUseCase {

    List<Mitarbeiter> findAll();

    Mitarbeiter findById(MitarbeiterId id);

}
