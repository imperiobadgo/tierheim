package org.example.tierheim.tier.application;

import lombok.RequiredArgsConstructor;
import org.example.tierheim.tier.Tier;
import org.example.tierheim.tier.TierId;
import org.example.tierheim.tier.TierRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ReadTierUseCaseImpl implements ReadTierUseCase{

    private final TierRepository repository;

    @Override
    public List<Tier> findAll() {
        return repository.findAll();
    }

    @Override
    public Tier findById(TierId id) {
        return repository.findById(id)
                .orElseThrow(() -> new TierNichtVorhandenException(id.toString()));
    }
}
