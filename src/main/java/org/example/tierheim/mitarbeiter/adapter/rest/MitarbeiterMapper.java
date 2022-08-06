package org.example.tierheim.mitarbeiter.adapter.rest;

import org.example.tierheim.mitarbeiter.Mitarbeiter;
import org.example.tierheim.mitarbeiter.adapter.shared.MitarbeiterIdMapper;
import org.example.tierheim.mitarbeiter.application.MitarbeiterChanges;
import org.example.tierheim.shared.NameMapper;
import org.mapstruct.Mapper;

@Mapper(uses = {
        MitarbeiterIdMapper.class,
        NameMapper.class
})
public interface MitarbeiterMapper {

    MitarbeiterReadModel toReadModel(Mitarbeiter domain);

    MitarbeiterChanges toChanges(MitarbeiterWriteModel model);

}
