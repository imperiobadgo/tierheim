package org.example.tierheim.reservierungen.adapter.rest;

import org.example.tierheim.bewerber.adapter.shared.BewerberIdMapper;
import org.example.tierheim.reservierungen.Reservierung;
import org.example.tierheim.reservierungen.adapter.shared.ReservierungIdMapper;
import org.example.tierheim.reservierungen.application.ReservierungChanges;
import org.example.tierheim.shared.NameMapper;
import org.mapstruct.Mapper;

@Mapper(uses = {
        ReservierungIdMapper.class,
        BewerberIdMapper.class,
        NameMapper.class
})
public interface ReservierungMapper {

    ReservierungReadModel toReadModel(Reservierung domain);

    ReservierungChanges toChanges(ReservierungCreateModel model);

    ReservierungChanges toChanges(ReservierungWriteModel model);
}
