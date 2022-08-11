package org.example.tierheim.bewerber.adapter.persistence;

import lombok.RequiredArgsConstructor;
import org.example.tierheim.bewerber.Bewerber;
import org.example.tierheim.bewerber.BewerberId;
import org.example.tierheim.bewerber.BewerberRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
final class BewerberRepositoryAdapter implements BewerberRepository {

    private final BewerberJpaRepository repository;
    private final BewerberJpaMapper mapper;

    @Override
    public List<Bewerber> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Bewerber> findById(final BewerberId id) {
        return repository.findById(id.getValue())
                .map(mapper::toDomain);
    }

    @Override
    public Bewerber save(final Bewerber input) {
        final BewerberJpa entity = mapper.toEntity(input);
        final BewerberJpa saved = repository.saveAndFlush(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Bewerber> delete(BewerberId id) {
        final Optional<BewerberJpa> entity = repository.findById(id.getValue());
        if (entity.isEmpty()){
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
