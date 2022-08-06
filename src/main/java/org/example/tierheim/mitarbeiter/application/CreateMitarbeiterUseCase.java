package org.example.tierheim.mitarbeiter.application;

import org.example.tierheim.mitarbeiter.Mitarbeiter;

public interface CreateMitarbeiterUseCase {

    Mitarbeiter execute(MitarbeiterChanges input);

}
