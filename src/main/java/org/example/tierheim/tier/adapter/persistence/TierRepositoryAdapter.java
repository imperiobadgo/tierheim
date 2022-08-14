package org.example.tierheim.tier.adapter.persistence;

import lombok.RequiredArgsConstructor;
import org.example.tierheim.tier.Tier;
import org.example.tierheim.tier.TierId;
import org.example.tierheim.tier.TierRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
class TierRepositoryAdapter implements TierRepository {

    private final TierJpaRepository repository;
    private final TierJpaMapper mapper;

    @Override
    public List<Tier> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Tier> findById(final TierId id) {
        return repository.findById(id.getValue())
                .map(mapper::toDomain);
    }

    @Override
    public Tier save(final Tier input) {
        final TierJpa entity = mapper.toEntity(input);
        final TierJpa saved = repository.saveAndFlush(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Tier> delete(TierId id) {
        final Optional<TierJpa> entity = repository.findById(id.getValue());
        if (entity.isEmpty()) {
            return Optional.empty();
        }
        repository.delete(entity.get());
        return Optional.ofNullable(mapper.toDomain(entity.get()));
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

}
