package org.example.tierheim.tier.adapter.persistence;

import org.example.tierheim.art.adapter.shared.ArtIdMapper;
import org.example.tierheim.bewerber.adapter.shared.BewerberIdMapper;
import org.example.tierheim.reservierungen.adapter.shared.ReservierungIdMapper;
import org.example.tierheim.shared.NameMapper;
import org.example.tierheim.tier.Tier;
import org.example.tierheim.tier.adapter.shared.TierIdMapper;
import org.mapstruct.Mapper;

@Mapper(uses = {
        TierIdMapper.class,
        BewerberIdMapper.class,
        ArtIdMapper.class,
        ReservierungIdMapper.class,
        NameMapper.class
})
interface TierJpaMapper {

    TierJpa toEntity(Tier domain);

    Tier toDomain(TierJpa entity);

}
