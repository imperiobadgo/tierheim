package org.example.tierheim.mitarbeiter.adapter.persistence;


import org.example.tierheim.mitarbeiter.Mitarbeiter;
import org.example.tierheim.mitarbeiter.adapter.shared.MitarbeiterIdMapper;
import org.example.tierheim.shared.NameMapper;
import org.mapstruct.Mapper;

@Mapper(uses = {
        MitarbeiterIdMapper.class,
        NameMapper.class
})
interface MitarbeiterJpaMapper {

    MitarbeiterJpa toEntity(Mitarbeiter domain);

    Mitarbeiter toDomain(MitarbeiterJpa entity);

}
