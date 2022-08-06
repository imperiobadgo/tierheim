package org.example.tierheim.mitarbeiter.application;

import org.example.tierheim.mitarbeiter.Mitarbeiter;
import org.example.tierheim.mitarbeiter.MitarbeiterId;

public interface EditMitarbeiterUseCase {

    Mitarbeiter execute(MitarbeiterId id, MitarbeiterChanges input);

}
