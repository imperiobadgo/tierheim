package org.example.tierheim.bewerber.application;

import org.example.tierheim.bewerber.Bewerber;

public interface CreateBewerberUseCase {

    Bewerber execute(BewerberChanges input);
}
