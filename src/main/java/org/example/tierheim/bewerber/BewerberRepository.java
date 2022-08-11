package org.example.tierheim.bewerber;

import java.util.List;
import java.util.Optional;

public interface BewerberRepository {

    List<Bewerber> findAll();

    Optional<Bewerber> findById(BewerberId id);

    Bewerber save(Bewerber input);

    Optional<Bewerber> delete(BewerberId id);

    void deleteAll();

}
