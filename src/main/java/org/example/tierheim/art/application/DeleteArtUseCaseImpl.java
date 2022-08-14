package org.example.tierheim.art.application;

import lombok.RequiredArgsConstructor;
import org.example.tierheim.art.Art;
import org.example.tierheim.art.ArtId;
import org.example.tierheim.art.ArtRepository;
import org.example.tierheim.bewerber.Bewerber;
import org.example.tierheim.bewerber.BewerberId;
import org.example.tierheim.bewerber.BewerberRepository;
import org.example.tierheim.bewerber.application.BewerberNichtVorhandenException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteArtUseCaseImpl implements DeleteArtUseCase{

    final private ArtRepository repository;

    @Override
    public Art execute(ArtId id) {
        return repository.delete(id)
                .orElseThrow(() -> new ArtNichtVorhandenException(id.toString()));
    }

    @Override
    public void all() {
        repository.deleteAll();
    }

}
