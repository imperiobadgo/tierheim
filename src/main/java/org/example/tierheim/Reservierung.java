package org.example.tierheim;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class Reservierung {

    @NonNull
    @Builder.Default
    ReservierungId id = new ReservierungId(UUID.randomUUID());

    @NonNull
    BewerberId bewerberId;

    String notizen;
}
