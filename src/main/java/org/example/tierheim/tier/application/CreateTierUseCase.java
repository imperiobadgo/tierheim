package org.example.tierheim.tier.application;

import org.example.tierheim.tier.Tier;

public interface CreateTierUseCase {

    Tier execute(TierChanges input);

}
