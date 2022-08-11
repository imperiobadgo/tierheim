package org.example.tierheim.bewerber.application;

import lombok.RequiredArgsConstructor;
import org.example.tierheim.bewerber.Bewerber;
import org.example.tierheim.bewerber.BewerberId;
import org.example.tierheim.bewerber.BewerberRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
final class DeleteBewerberUseCaseImpl implements DeleteBewerberUseCase {

    final private BewerberRepository repository;

    @Override
    public Bewerber execute(BewerberId id) {
        return repository.delete(id)
                .orElseThrow(() -> new BewerberNichtVorhandenException(id.toString()));
    }

    @Override
    public void all() {
        repository.deleteAll();
    }
}
