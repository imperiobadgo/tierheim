package org.example.tierheim.reservierungen.adapter.persistence;

import lombok.RequiredArgsConstructor;
import org.example.tierheim.reservierungen.Reservierung;
import org.example.tierheim.reservierungen.ReservierungId;
import org.example.tierheim.reservierungen.ReservierungRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ReservierungRepositoryAdapter implements ReservierungRepository {

    private final ReservierungJpaRepository repository;
    private final ReservierungJpaMapper mapper;

    @Override
    public List<Reservierung> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Reservierung> findById(ReservierungId id) {
        return repository.findById(id.getValue())
                .map(mapper::toDomain);
    }

    @Override
    public Reservierung save(Reservierung reservierung) {
        final ReservierungJpa entity = mapper.toEntity(reservierung);
        final ReservierungJpa saved = repository.saveAndFlush(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Reservierung> delete(ReservierungId id) {
        final Optional<ReservierungJpa> entity = repository.findById(id.getValue());
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
