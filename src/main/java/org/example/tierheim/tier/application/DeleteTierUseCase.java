package org.example.tierheim.tier.application;

import org.example.tierheim.tier.Tier;
import org.example.tierheim.tier.TierId;

public interface DeleteTierUseCase {

    Tier execute(TierId id);

    void all();

}
