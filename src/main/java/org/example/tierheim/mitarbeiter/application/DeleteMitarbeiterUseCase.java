package org.example.tierheim.mitarbeiter.application;

import org.example.tierheim.mitarbeiter.Mitarbeiter;
import org.example.tierheim.mitarbeiter.MitarbeiterId;

public interface DeleteMitarbeiterUseCase {

    Mitarbeiter execute(MitarbeiterId id);

    void all();

}
