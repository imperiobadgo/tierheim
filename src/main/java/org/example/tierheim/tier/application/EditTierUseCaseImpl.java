package org.example.tierheim.tier.application;

import lombok.RequiredArgsConstructor;
import org.example.tierheim.tier.Tier;
import org.example.tierheim.tier.TierId;
import org.example.tierheim.tier.TierRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EditTierUseCaseImpl implements EditTierUseCase{

    private final TierRepository repository;

    @Override
    public Tier execute(TierId id, TierChanges input) {
        final Tier tier = repository.findById(id)
                .orElseThrow(() -> new TierNichtVorhandenException(id.toString()));
        final Tier updated = input.apply(tier.toBuilder());
        return repository.save(updated);
    }
}
