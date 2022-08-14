package org.example.tierheim.art.adapter.rest;

import org.example.tierheim.art.Art;
import org.example.tierheim.art.adapter.shared.ArtIdMapper;
import org.example.tierheim.art.application.ArtChanges;
import org.example.tierheim.shared.NameMapper;
import org.mapstruct.Mapper;

@Mapper(uses = {
        ArtIdMapper.class,
        NameMapper.class
})
public interface ArtMapper {

    ArtReadModel toReadModel(Art domain);

    ArtChanges toChanges(ArtCreateModel model);

}
