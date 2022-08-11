package org.example.tierheim.bewerber.adapter.persistence;


import org.example.tierheim.bewerber.Bewerber;
import org.example.tierheim.bewerber.adapter.shared.BewerberIdMapper;
import org.example.tierheim.shared.NameMapper;
import org.mapstruct.Mapper;

@Mapper(uses = {
        BewerberIdMapper.class,
        NameMapper.class
})
interface BewerberJpaMapper {

    Bewerber toDomain(BewerberJpa entity);

    BewerberJpa toEntity(Bewerber domain);

}
