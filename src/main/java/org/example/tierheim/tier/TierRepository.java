package org.example.tierheim.tier;

import java.util.List;
import java.util.Optional;

public interface TierRepository {

    List<Tier> findAll();

    Optional<Tier> findById(TierId id);

    Tier save(Tier input);

    Optional<Tier> delete(TierId id);

    void deleteAll();

}
