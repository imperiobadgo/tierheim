package org.example.tierheim.tier.application;

import org.example.tierheim.bewerber.BewerberId;
import org.example.tierheim.tier.Tier;
import org.example.tierheim.tier.TierId;

public interface ReservierungStornierenUseCase {

    Tier execute(TierId id, BewerberId input);

}
