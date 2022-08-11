package org.example.tierheim.mitarbeiter.adapter.persistence;

import lombok.RequiredArgsConstructor;
import org.example.tierheim.mitarbeiter.Mitarbeiter;
import org.example.tierheim.mitarbeiter.MitarbeiterId;
import org.example.tierheim.mitarbeiter.MitarbeiterRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
final class MitarbeiterRepositoryAdapter implements MitarbeiterRepository {

    private final MitarbeiterJpaRepository repository;
    private final MitarbeiterJpaMapper mapper;

    @Override
    public List<Mitarbeiter> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Mitarbeiter> findById(final MitarbeiterId id) {
        return repository.findById(id.getValue())
                .map(mapper::toDomain);
    }

    @Override
    public Mitarbeiter save(final Mitarbeiter mitarbeiter) {
        final MitarbeiterJpa entity = mapper.toEntity(mitarbeiter);
        final MitarbeiterJpa saved = repository.saveAndFlush(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Mitarbeiter> delete(MitarbeiterId id) {
        final Optional<MitarbeiterJpa> entity = repository.findById(id.getValue());
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
