package org.example.tierheim.art.application;

import org.example.tierheim.art.Art;
import org.example.tierheim.art.ArtId;

import java.util.List;

public interface ReadArtUseCase {

    List<Art> findAll();

    Art findById(ArtId id);

}
