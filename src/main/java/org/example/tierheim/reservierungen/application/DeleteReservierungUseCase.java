package org.example.tierheim.reservierungen.application;

import org.example.tierheim.reservierungen.Reservierung;
import org.example.tierheim.reservierungen.ReservierungId;

public interface DeleteReservierungUseCase {

    Reservierung execute(ReservierungId id);

    void all();
}
