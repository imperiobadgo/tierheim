package org.example.tierheim.mitarbeiter.adapter.shared;

import org.example.tierheim.mitarbeiter.MitarbeiterId;

import java.util.UUID;

public class MitarbeiterIdMapper {

    public static MitarbeiterId fromUuid(final UUID value) {
        return new MitarbeiterId(value);
    }

    public static UUID toUuid(final MitarbeiterId id) {
        return id.getValue();
    }

    private MitarbeiterIdMapper() {
        throw new AssertionError();
    }

}
