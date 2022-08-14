package org.example.tierheim.tier.adapter.rest;

import org.example.tierheim.art.adapter.shared.ArtIdMapper;
import org.example.tierheim.reservierungen.adapter.shared.ReservierungIdMapper;
import org.example.tierheim.shared.NameMapper;
import org.example.tierheim.tier.Tier;
import org.example.tierheim.tier.adapter.shared.TierIdMapper;
import org.example.tierheim.tier.application.TierChanges;
import org.mapstruct.Mapper;

@Mapper(uses = {
        TierIdMapper.class,
        ArtIdMapper.class,
        ReservierungIdMapper.class,
        NameMapper.class
})
public interface TierMapper {

    TierReadModel toReadModel(Tier domain);

    TierChanges toChanges(TierCreateModel model);

    TierChanges toChanges(TierWriteModel model);

}
