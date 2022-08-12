package org.example.tierheim.reservierungen.application;

import lombok.RequiredArgsConstructor;
import org.example.tierheim.reservierungen.Reservierung;
import org.example.tierheim.reservierungen.ReservierungId;
import org.example.tierheim.reservierungen.ReservierungRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EditReservierungUseCaseImpl implements EditReservierungUseCase{

    private final ReservierungRepository repository;

    @Override
    public Reservierung execute(ReservierungId id, ReservierungChanges input) {
        final Reservierung reservierung = repository.findById(id)
                .orElseThrow(() -> new ReservierungNichtVorhandenException(id.toString()));
        final Reservierung updated = input.apply(reservierung.toBuilder());
        return repository.save(updated);
    }
}
