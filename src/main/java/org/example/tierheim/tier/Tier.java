package org.example.tierheim.tier;

import lombok.Builder;
import lombok.NonNull;
import lombok.ToString;
import lombok.Value;
import org.example.tierheim.art.ArtId;
import org.example.tierheim.bewerber.BewerberId;
import org.example.tierheim.reservierungen.Reservierung;
import org.example.tierheim.reservierungen.ReservierungId;
import org.example.tierheim.reservierungen.application.*;
import org.example.tierheim.shared.Name;

import java.util.Optional;
import java.util.UUID;

import static org.example.tierheim.tier.Geschlecht.UNBEKANNT;
import static org.example.tierheim.tier.TierStatus.OFFEN;
import static org.example.tierheim.tier.TierStatus.RESERVIERT;

@Value
@Builder(toBuilder = true)
@ToString(doNotUseGetters = true)
public class Tier {

    @NonNull
    @Builder.Default
    TierId id = new TierId(UUID.randomUUID());

    @Builder.Default
    long version = 0;

    @NonNull
    @Builder.Default
    TierStatus status = OFFEN;

    @NonNull
    @Builder.Default
    Geschlecht geschlecht = UNBEKANNT;

    @NonNull
    Name name;

    ArtId art;

    ReservierungId reservierung;

    /**
     *
     * @param bewerberId
     * @return
     * @throws ReservierungNichtMoeglichException
     */
    public Tier reservieren(BewerberId bewerberId, CreateReservierungUseCase createReservierung)
    {
        if (status != OFFEN) {
            throw new ReservierungNichtMoeglichException(status);
        }

        final ReservierungChanges newReservierung = ReservierungChanges.builder()
                .bewerberId(bewerberId)
                .build();

        final Reservierung createdReservierung = createReservierung.execute(newReservierung);

        final Tier updated = this.toBuilder()
                .reservierung(createdReservierung.getId())
                .status(RESERVIERT)
                .build();
        return updated;
    }

    /**
     *
     * @param bewerberId Ursprünglicher Bewerber für das Tier.
     * @return
     * @throws ReservierungStornierenNichtMoeglichException Wenn das Tier noch nicht reserviert ist oder wenn jemand anderes Reserviert hat.
     */
    public Tier reservierungStornieren(BewerberId bewerberId, ReadReservierungUseCase readReservierung, DeleteReservierungUseCase deleteReservierung)
    {
        if (status != RESERVIERT || reservierung != null)
        {
            throw new ReservierungStornierenNichtMoeglichException("Keine Reservierung vorhanden!");
        }
        final Reservierung reservierung1 = readReservierung.findById(reservierung);

        if (reservierung1.getBewerberId().getValue() != bewerberId.getValue())
        {
            throw new ReservierungStornierenNichtMoeglichException("Reservierung wurde von jemand anderem Vorgenommen!");
        }

        final Reservierung reservierung2 = deleteReservierung.execute(reservierung);

        final Tier updated = this.toBuilder()
                .reservierung(null)
                .status(OFFEN)
                .build();
        return updated;
    }


    public Optional<ArtId> getArt() {
        return Optional.ofNullable(art);
    }

}
