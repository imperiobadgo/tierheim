package org.example.tierheim.bewerber.application;

import org.example.tierheim.bewerber.Bewerber;
import org.example.tierheim.bewerber.BewerberId;

public interface EditBewerberUseCase {

    Bewerber execute(BewerberId id, BewerberChanges input);

}
