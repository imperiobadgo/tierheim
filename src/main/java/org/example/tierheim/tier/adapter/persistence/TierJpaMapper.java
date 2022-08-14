package org.example.tierheim.tier.adapter.persistence;

import org.example.tierheim.shared.NameMapper;
import org.example.tierheim.tier.Tier;
import org.example.tierheim.tier.adapter.shared.TierIdMapper;
import org.mapstruct.Mapper;

@Mapper(uses = {
        TierIdMapper.class,
        NameMapper.class
})
interface TierJpaMapper {

    TierJpa toEntity(Tier domain);

    Tier toDomain(TierJpa entity);

}
