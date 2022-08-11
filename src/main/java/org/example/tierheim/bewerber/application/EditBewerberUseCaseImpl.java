package org.example.tierheim.bewerber.application;

import lombok.RequiredArgsConstructor;
import org.example.tierheim.bewerber.Bewerber;
import org.example.tierheim.bewerber.BewerberId;
import org.example.tierheim.bewerber.BewerberRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
final class EditBewerberUseCaseImpl implements EditBewerberUseCase{

    final private BewerberRepository repository;

    @Override
    public Bewerber execute(BewerberId id, BewerberChanges input) {
        final Bewerber bewerber = repository.findById(id)
                .orElseThrow(() -> new BewerberNichtVorhandenException(id.toString()));
        final Bewerber updated = input.apply(bewerber.toBuilder());
        return repository.save(updated);
    }
}
