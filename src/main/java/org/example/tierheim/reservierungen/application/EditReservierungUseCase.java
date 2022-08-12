package org.example.tierheim.reservierungen.application;

import org.example.tierheim.reservierungen.Reservierung;
import org.example.tierheim.reservierungen.ReservierungId;

public interface EditReservierungUseCase {

    Reservierung execute(ReservierungId id, ReservierungChanges input);
}
