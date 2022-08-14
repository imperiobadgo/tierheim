package org.example.tierheim.art.application;

import org.example.tierheim.art.Art;
import org.example.tierheim.art.ArtId;

public interface DeleteArtUseCase {

    Art execute(ArtId id);

    void all();

}
