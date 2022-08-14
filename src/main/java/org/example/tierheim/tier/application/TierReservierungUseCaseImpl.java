package org.example.tierheim.tier.application;

import lombok.RequiredArgsConstructor;
import org.example.tierheim.bewerber.BewerberId;
import org.example.tierheim.reservierungen.application.CreateReservierungUseCase;
import org.example.tierheim.tier.Tier;
import org.example.tierheim.tier.TierId;
import org.example.tierheim.tier.TierRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TierReservierungUseCaseImpl implements TierReservierenUseCase{

    private final TierRepository repository;

    private final CreateReservierungUseCase createReservierung;

    @Override
    public Tier execute(TierId id, BewerberId input) {
        final Tier tier = repository.findById(id)
                .orElseThrow(() -> new TierNichtVorhandenException(id.toString()));

        final Tier updated = tier.reservieren(input, createReservierung);
        return repository.save(updated);
    }
}
