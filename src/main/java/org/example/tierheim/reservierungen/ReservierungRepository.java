package org.example.tierheim.reservierungen;

import java.util.List;
import java.util.Optional;

public interface ReservierungRepository {

    List<Reservierung> findAll();

    Optional<Reservierung> findById(ReservierungId id);

    Reservierung save(Reservierung reservierung);

    Optional<Reservierung> delete(ReservierungId id);

    void deleteAll();
}
