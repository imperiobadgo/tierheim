package org.example.tierheim.art;

import java.util.List;
import java.util.Optional;

public interface ArtRepository {
    List<Art> findAll();

    Optional<Art> findById(ArtId id);

    Art save(Art input);

    Optional<Art> delete(ArtId id);

    void deleteAll();

}
