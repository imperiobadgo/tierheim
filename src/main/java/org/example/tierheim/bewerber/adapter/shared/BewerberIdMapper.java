package org.example.tierheim.bewerber.adapter.shared;

import org.example.tierheim.bewerber.BewerberId;

import java.util.UUID;

public class BewerberIdMapper {

    public static BewerberId fromUuid(final UUID id){
        return new BewerberId(id);
    }

    public static UUID toUuid(final BewerberId id){
        return id.getValue();
    }

    private BewerberIdMapper() {throw new AssertionError();}
}
