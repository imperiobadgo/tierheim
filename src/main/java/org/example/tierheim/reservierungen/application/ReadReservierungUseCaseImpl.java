package org.example.tierheim.reservierungen.application;

import lombok.RequiredArgsConstructor;
import org.example.tierheim.reservierungen.Reservierung;
import org.example.tierheim.reservierungen.ReservierungId;
import org.example.tierheim.reservierungen.ReservierungRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ReadReservierungUseCaseImpl implements ReadReservierungUseCase{

    private final ReservierungRepository repository;

    @Override
    public List<Reservierung> findAll()  {
        return repository.findAll();
    }

    @Override
    public Reservierung findById(ReservierungId id) {
        return repository.findById(id)
                .orElseThrow(() -> new ReservierungNichtVorhandenException(id.toString()));
    }
}
