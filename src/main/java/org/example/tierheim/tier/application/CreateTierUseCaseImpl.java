package org.example.tierheim.tier.application;

import lombok.RequiredArgsConstructor;
import org.example.tierheim.tier.Tier;
import org.example.tierheim.tier.TierRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateTierUseCaseImpl implements CreateTierUseCase{

    private final TierRepository repository;

    @Override
    public Tier execute(TierChanges input) {
        final Tier tier = input.apply(Tier.builder());
        return repository.save(tier);
    }
}
