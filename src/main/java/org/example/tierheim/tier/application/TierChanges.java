package org.example.tierheim.tier.application;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import org.example.tierheim.art.ArtId;
import org.example.tierheim.reservierungen.ReservierungId;
import org.example.tierheim.shared.Name;
import org.example.tierheim.tier.Geschlecht;
import org.example.tierheim.tier.Tier;
import org.example.tierheim.tier.TierStatus;

import static org.example.tierheim.tier.Geschlecht.UNBEKANNT;
import static org.example.tierheim.tier.TierStatus.OFFEN;

@Value
@Builder
public class TierChanges {

    @NonNull
    TierStatus status = OFFEN;

    @NonNull
    Geschlecht geschlecht = UNBEKANNT;

    @NonNull
    Name name;

    ArtId art;

    ReservierungId reservierung;

    public Tier apply(final Tier.TierBuilder builder){
        return builder
                .status(status)
                .geschlecht(geschlecht)
                .name(name)
                .art(art)
                .reservierung(reservierung)
                .build();
    }


}
