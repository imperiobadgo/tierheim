package org.example.tierheim.tier.application;

import lombok.RequiredArgsConstructor;
import org.example.tierheim.reservierungen.Reservierung;
import org.example.tierheim.reservierungen.application.DeleteReservierungUseCase;
import org.example.tierheim.reservierungen.application.ReadReservierungUseCase;
import org.example.tierheim.tier.Tier;
import org.example.tierheim.tier.TierId;
import org.example.tierheim.tier.TierRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DeleteTierUseCaseImpl implements DeleteTierUseCase {

    private final TierRepository repository;

    private final ReadReservierungUseCase readReservierungUseCase;

    private final DeleteReservierungUseCase deleteReservierungUseCase;

    @Override
    public Tier execute(TierId id) {
        final Tier tier = repository.findById(id)
                .orElseThrow(() -> new TierNichtVorhandenException(id.toString()));

        //Falls eine Reservierung für das Tier vorliegt, muss diese erst storniert werden
        ueberpruefeUndStorniereReservierung(tier);

        return repository.delete(id)
                .orElseThrow(() -> new TierNichtVorhandenException(id.toString()));
    }

    @Override
    public void all() {
        List<Tier> tiere = repository.findAll();
        for (Tier tier: tiere) {
            ueberpruefeUndStorniereReservierung(tier);
        }

        repository.deleteAll();
    }

    private void ueberpruefeUndStorniereReservierung(Tier tier){
        //Falls eine Reservierung für das Tier vorliegt, muss diese erst storniert werden
        if (tier.getReservierung() != null) {
            final Reservierung reservierung = readReservierungUseCase.findById(tier.getReservierung());
            tier.reservierungStornieren(reservierung.getBewerberId(), readReservierungUseCase, deleteReservierungUseCase);
        }
    }

}
