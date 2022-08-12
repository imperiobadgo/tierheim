package org.example.tierheim.reservierungen.application;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import org.example.tierheim.bewerber.BewerberId;
import org.example.tierheim.reservierungen.Reservierung;

@Value
@Builder
public class ReservierungChanges {

    @NonNull
    BewerberId bewerberId;

    String notizen;

    public Reservierung apply(final Reservierung.ReservierungBuilder builder){
        return builder
                .bewerberId(bewerberId)
                .notizen(notizen)
                .build();
    }

}
