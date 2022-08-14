package org.example.tierheim.tier.adapter.shared;

import org.example.tierheim.tier.TierId;

import java.util.UUID;

public class TierIdMapper {

    public static TierId fromUuid(final UUID value) {
        return new TierId(value);
    }

    public static UUID toUuid(final TierId id) {
        return id.getValue();
    }

    private TierIdMapper() {
        throw new AssertionError();
    }

}
