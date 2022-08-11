package org.example.tierheim.bewerber.application;

import lombok.RequiredArgsConstructor;
import org.example.tierheim.bewerber.Bewerber;
import org.example.tierheim.bewerber.BewerberRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
final class CreateBewerberUseCaseImpl implements CreateBewerberUseCase{

    private final BewerberRepository repository;

    @Override
    public Bewerber execute(BewerberChanges input) {
        final Bewerber bewerber = input.apply(Bewerber.builder());
        return repository.save(bewerber);
    }
}
