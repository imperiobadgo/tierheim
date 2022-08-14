package org.example.tierheim.art.application;

import lombok.RequiredArgsConstructor;
import org.example.tierheim.art.Art;
import org.example.tierheim.art.ArtId;
import org.example.tierheim.art.ArtRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ReadArtUseCaseImpl implements ReadArtUseCase{

    final private ArtRepository repository;

    @Override
    public List<Art> findAll() {
        return repository.findAll();
    }

    @Override
    public Art findById(ArtId id) {
        return repository.findById(id)
                .orElseThrow(() -> new ArtNichtVorhandenException(id.toString()));
    }

}
