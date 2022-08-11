package org.example.tierheim;

import lombok.Builder;
import lombok.NonNull;
import lombok.ToString;
import lombok.Value;
import org.example.tierheim.bewerber.BewerberId;
import org.example.tierheim.shared.Name;

import java.util.Optional;
import java.util.UUID;

import static org.example.tierheim.Geschlecht.UNBEKANNT;
import static org.example.tierheim.TierStatus.OFFEN;
import static org.example.tierheim.TierStatus.RESERVIERT;

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


    //JPA-Relations in der Datenbank für automatisches auflösen
    Reservierung reservierung;

    /**
     *
     * @param bewerberId
     * @return
     * @throws ReservierungNichtMoeglichException
     */
    public Tier reservieren(BewerberId bewerberId)
    {
        if (status != OFFEN) {
            throw new ReservierungNichtMoeglichException(status);
        }

        final Reservierung reservierung = Reservierung.builder()
                .bewerberId(bewerberId)
                .build();

        final Tier updated = this.toBuilder()
                .reservierung(reservierung)
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
    public Tier reservierungStornieren(BewerberId bewerberId)
    {
        if (status != RESERVIERT || reservierung != null)
        {
            throw new ReservierungStornierenNichtMoeglichException("Keine Reservierung vorhanden!");
        }
        if (reservierung.getBewerberId().getValue() != bewerberId.getValue())
        {
            throw new ReservierungStornierenNichtMoeglichException("Reservierung wurde von jemand anderem Vorgenommen!");
        }

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
