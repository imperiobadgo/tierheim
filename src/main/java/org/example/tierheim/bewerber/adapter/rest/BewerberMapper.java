package org.example.tierheim.bewerber.adapter.rest;

import org.example.tierheim.bewerber.Bewerber;
import org.example.tierheim.bewerber.adapter.shared.BewerberIdMapper;
import org.example.tierheim.bewerber.application.BewerberChanges;
import org.example.tierheim.shared.NameMapper;
import org.mapstruct.Mapper;

@Mapper(uses = {
        BewerberIdMapper.class,
        NameMapper.class
})
public interface BewerberMapper {

    BewerberReadModel toReadModel(Bewerber domain);

    BewerberChanges toChanges(BewerberCreateModel model);

    BewerberChanges toChanges(BewerberWriteModel model);

}
