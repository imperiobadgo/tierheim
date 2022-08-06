package org.example.tierheim.mitarbeiter.application;

import lombok.RequiredArgsConstructor;
import org.example.tierheim.mitarbeiter.Mitarbeiter;
import org.example.tierheim.mitarbeiter.MitarbeiterRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
final class CreateMitarbeiterUseCaseImpl implements CreateMitarbeiterUseCase {

    private final MitarbeiterRepository repository;

    @Override
    public Mitarbeiter execute(final MitarbeiterChanges input) {
        final Mitarbeiter mitarbeiter = input.apply(Mitarbeiter.builder());
        return repository.save(mitarbeiter);
    }

}
