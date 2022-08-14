package org.example.tierheim.art.application;

import org.example.tierheim.art.Art;

public interface CreateArtUseCase {

    Art execute(ArtChanges input);

}
