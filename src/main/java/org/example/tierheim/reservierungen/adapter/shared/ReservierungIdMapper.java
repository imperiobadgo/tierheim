package org.example.tierheim.reservierungen.adapter.shared;

import org.example.tierheim.reservierungen.ReservierungId;

import java.util.UUID;

public class ReservierungIdMapper {

    public static ReservierungId fromUuid(final UUID value) {
        return new ReservierungId(value);
    }

    public static UUID toUuid(final ReservierungId id) {
        return id.getValue();
    }

    private ReservierungIdMapper() {
        throw new AssertionError();
    }

}
