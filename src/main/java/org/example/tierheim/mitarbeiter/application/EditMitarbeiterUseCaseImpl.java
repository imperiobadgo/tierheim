package org.example.tierheim.mitarbeiter.application;

import lombok.RequiredArgsConstructor;
import org.example.tierheim.mitarbeiter.Mitarbeiter;
import org.example.tierheim.mitarbeiter.MitarbeiterId;
import org.example.tierheim.mitarbeiter.MitarbeiterRepository;
import org.example.tierheim.mitarbeiter.adapter.rest.MitarbeiterNichtVorhandenException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
final class EditMitarbeiterUseCaseImpl implements EditMitarbeiterUseCase {

    private final MitarbeiterRepository repository;

    @Override
    public Mitarbeiter execute(final MitarbeiterId id, final MitarbeiterChanges input) {
        final Mitarbeiter mitarbeiter = repository.findById(id)
                .orElseThrow(() -> new MitarbeiterNichtVorhandenException(id.toString()));
        final Mitarbeiter updated = input.apply(mitarbeiter.toBuilder());
        return repository.save(updated);
    }

}
