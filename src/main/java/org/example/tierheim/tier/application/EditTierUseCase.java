package org.example.tierheim.tier.application;

import org.example.tierheim.tier.Tier;
import org.example.tierheim.tier.TierId;

public interface EditTierUseCase {

    Tier execute(TierId id, TierChanges input);

}
