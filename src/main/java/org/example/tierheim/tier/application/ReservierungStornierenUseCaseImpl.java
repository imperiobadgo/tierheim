package org.example.tierheim.tier.application;

import lombok.RequiredArgsConstructor;
import org.example.tierheim.bewerber.BewerberId;
import org.example.tierheim.reservierungen.application.DeleteReservierungUseCase;
import org.example.tierheim.reservierungen.application.ReadReservierungUseCase;
import org.example.tierheim.tier.Tier;
import org.example.tierheim.tier.TierId;
import org.example.tierheim.tier.TierRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReservierungStornierenUseCaseImpl implements ReservierungStornierenUseCase{

    private final TierRepository repository;

    private final ReadReservierungUseCase readReservierungUseCase;

    private final DeleteReservierungUseCase deleteReservierungUseCase;

    @Override
    public Tier execute(TierId id, BewerberId input) {
        final Tier tier = repository.findById(id)
                .orElseThrow(() -> new TierNichtVorhandenException(id.toString()));

        final Tier updated = tier.reservierungStornieren(input, readReservierungUseCase, deleteReservierungUseCase);

        return repository.save(updated);
    }
}
