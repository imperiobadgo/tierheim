package org.example.tierheim.mitarbeiter.application;

import lombok.RequiredArgsConstructor;
import org.example.tierheim.mitarbeiter.Mitarbeiter;
import org.example.tierheim.mitarbeiter.MitarbeiterId;
import org.example.tierheim.mitarbeiter.MitarbeiterRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
final class DeleteMitarbeiterUseCaseImpl implements DeleteMitarbeiterUseCase{

    private final MitarbeiterRepository repository;

    @Override
    public Mitarbeiter execute(MitarbeiterId id) {
        return repository.delete(id)
                .orElseThrow(() -> new MitarbeiterNichtVorhandenException(id.toString()));
    }

    @Override
    public void all() {
        repository.deleteAll();
    }
}
