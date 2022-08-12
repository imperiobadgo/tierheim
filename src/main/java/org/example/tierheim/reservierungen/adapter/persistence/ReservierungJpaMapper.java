package org.example.tierheim.reservierungen.adapter.persistence;

import org.example.tierheim.reservierungen.Reservierung;
import org.example.tierheim.reservierungen.adapter.shared.ReservierungIdMapper;
import org.example.tierheim.shared.NameMapper;
import org.mapstruct.Mapper;

@Mapper(uses = {
        ReservierungIdMapper.class,
        NameMapper.class
})
interface ReservierungJpaMapper {

    Reservierung toDomain(ReservierungJpa entity);

    ReservierungJpa toEntity(Reservierung domain);
}
