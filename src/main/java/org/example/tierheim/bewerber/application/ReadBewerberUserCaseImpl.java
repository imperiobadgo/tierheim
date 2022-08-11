package org.example.tierheim.bewerber.application;

import lombok.RequiredArgsConstructor;
import org.example.tierheim.bewerber.Bewerber;
import org.example.tierheim.bewerber.BewerberId;
import org.example.tierheim.bewerber.BewerberRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
final class ReadBewerberUserCaseImpl implements ReadBewerberUseCase {

    final private BewerberRepository repository;

    @Override
    public List<Bewerber> findAll() {
        return repository.findAll();
    }

    @Override
    public Bewerber findById(BewerberId id) {
        return repository.findById(id)
                .orElseThrow(() -> new BewerberNichtVorhandenException(id.toString()));
    }
}
