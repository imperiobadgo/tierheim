package org.example.tierheim.art.application;

import lombok.RequiredArgsConstructor;
import org.example.tierheim.art.Art;
import org.example.tierheim.art.ArtRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateArtUseCaseImpl implements CreateArtUseCase{

    final private ArtRepository repository;

    @Override
    public Art execute(ArtChanges input) {
        final Art art = input.apply(Art.builder());
        return repository.save(art);
    }
}
