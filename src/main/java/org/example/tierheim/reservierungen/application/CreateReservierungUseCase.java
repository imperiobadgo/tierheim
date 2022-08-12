package org.example.tierheim.reservierungen.application;

import org.example.tierheim.reservierungen.Reservierung;

public interface CreateReservierungUseCase {

    Reservierung execute(ReservierungChanges input);
}
