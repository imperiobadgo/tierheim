package org.example.tierheim.bewerber.application;

import org.example.tierheim.bewerber.Bewerber;
import org.example.tierheim.bewerber.BewerberId;

import java.util.List;

public interface ReadBewerberUseCase {

    List<Bewerber> findAll();

    Bewerber findById(BewerberId id);
}
