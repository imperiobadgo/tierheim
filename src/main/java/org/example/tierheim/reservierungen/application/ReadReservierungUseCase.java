package org.example.tierheim.reservierungen.application;

import org.example.tierheim.reservierungen.Reservierung;
import org.example.tierheim.reservierungen.ReservierungId;

import java.util.List;

public interface ReadReservierungUseCase {

    List<Reservierung> findAll();

    Reservierung findById(ReservierungId id);

}
