package org.example.tierheim.mitarbeiter.application;

import lombok.RequiredArgsConstructor;
import org.example.tierheim.mitarbeiter.Mitarbeiter;
import org.example.tierheim.mitarbeiter.MitarbeiterId;
import org.example.tierheim.mitarbeiter.MitarbeiterRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
final class ReadMitarbeiterUseCaseImpl implements ReadMitarbeiterUseCase {

    private final MitarbeiterRepository repository;

    @Override
    public List<Mitarbeiter> findAll() {
        return repository.findAll();
    }

    @Override
    public Mitarbeiter findById(final MitarbeiterId id) {
        return repository.findById(id)
                .orElseThrow(() -> new MitarbeiterNichtVorhandenException(id.toString()));
    }

}
