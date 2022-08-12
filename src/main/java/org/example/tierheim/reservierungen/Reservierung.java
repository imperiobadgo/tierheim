package org.example.tierheim.reservierungen;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import org.example.tierheim.bewerber.BewerberId;

import java.util.UUID;

@Value
@Builder(toBuilder = true)
public class Reservierung {

    @NonNull
    @Builder.Default
    ReservierungId id = new ReservierungId(UUID.randomUUID());

    @Builder.Default
    long version = 0;

    @NonNull
    BewerberId bewerberId;

    String notizen;
}
