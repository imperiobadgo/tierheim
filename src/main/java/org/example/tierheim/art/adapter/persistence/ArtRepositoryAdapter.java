package org.example.tierheim.art.adapter.persistence;

import lombok.RequiredArgsConstructor;
import org.example.tierheim.art.Art;
import org.example.tierheim.art.ArtId;
import org.example.tierheim.art.ArtRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
final class ArtRepositoryAdapter implements ArtRepository {

    private final ArtJpaRepository repository;
    private final ArtJpaMapper mapper;

    @Override
    public List<Art> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Art> findById(final ArtId id) {
        return repository.findById(id.getValue())
                .map(mapper::toDomain);
    }

    @Override
    public Art save(final Art input) {
        final ArtJpa entity = mapper.toEntity(input);
        final ArtJpa saved = repository.saveAndFlush(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Art> delete(ArtId id) {
        final Optional<ArtJpa> entity = repository.findById(id.getValue());
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
