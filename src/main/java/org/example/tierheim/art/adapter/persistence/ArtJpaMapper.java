package org.example.tierheim.art.adapter.persistence;

import org.example.tierheim.art.Art;
import org.example.tierheim.art.adapter.shared.ArtIdMapper;
import org.example.tierheim.shared.NameMapper;
import org.mapstruct.Mapper;

@Mapper(uses = {
        ArtIdMapper.class,
        NameMapper.class
})
interface ArtJpaMapper {

    Art toDomain(ArtJpa entity);

    ArtJpa toEntity(Art domain);

}
