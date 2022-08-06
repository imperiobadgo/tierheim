package org.example.tierheim.mitarbeiter;

import java.util.List;
import java.util.Optional;

public interface MitarbeiterRepository {

    List<Mitarbeiter> findAll();

    Optional<Mitarbeiter> findById(MitarbeiterId id);

    Mitarbeiter save(Mitarbeiter mitarbeiter);

}
