package org.example.tierheim.reservierungen.application;

import lombok.RequiredArgsConstructor;
import org.example.tierheim.reservierungen.Reservierung;
import org.example.tierheim.reservierungen.ReservierungRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateReservierungUseCaseImpl implements CreateReservierungUseCase{

    private final ReservierungRepository repository;

    @Override
    public Reservierung execute(ReservierungChanges input) {
        final Reservierung reservierung = input.apply(Reservierung.builder());
        return repository.save(reservierung);
    }
}
