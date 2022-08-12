package org.example.tierheim.reservierungen.application;

import lombok.RequiredArgsConstructor;
import org.example.tierheim.reservierungen.Reservierung;
import org.example.tierheim.reservierungen.ReservierungId;
import org.example.tierheim.reservierungen.ReservierungRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteReservierungUseCaseImpl implements DeleteReservierungUseCase{

    private final ReservierungRepository repository;

    @Override
    public Reservierung execute(ReservierungId id) {
        return repository.delete(id)
                .orElseThrow(() -> new ReservierungNichtVorhandenException(id.toString()));
    }

    @Override
    public void all() {
        repository.deleteAll();
    }
}
