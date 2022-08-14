package org.example.tierheim.tier.application;

import org.example.tierheim.tier.Tier;
import org.example.tierheim.tier.TierId;

import java.util.List;

public interface ReadTierUseCase {

    List<Tier> findAll();

    Tier findById(TierId id);

}
