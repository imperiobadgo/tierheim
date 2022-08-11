package org.example.tierheim.bewerber.application;

import org.example.tierheim.bewerber.Bewerber;
import org.example.tierheim.bewerber.BewerberId;

public interface DeleteBewerberUseCase {

    Bewerber execute(BewerberId id);

    void all();
}
