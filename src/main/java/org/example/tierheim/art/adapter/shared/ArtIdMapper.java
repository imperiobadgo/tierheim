package org.example.tierheim.art.adapter.shared;

import org.example.tierheim.art.ArtId;

import java.util.Optional;
import java.util.UUID;

public class ArtIdMapper {

    public static ArtId fromUuid(final UUID id) {
        return new ArtId(id);
    }

    public static UUID toUuid(final ArtId id) {
        return id.getValue();
    }

    public static Optional<ArtId> fromUuidOptional(final UUID id) {
        return Optional.of(new ArtId(id));
    }

    public static UUID toUuidOptional(final Optional<ArtId> id) {
        if (id.isEmpty())
            return null;

        return id.get().getValue();
    }

    private ArtIdMapper() {
        throw new AssertionError();
    }
}
