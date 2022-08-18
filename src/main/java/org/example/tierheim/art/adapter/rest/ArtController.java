package org.example.tierheim.art.adapter.rest;

import io.swagger.v3.oas.annotations.Operation;
import org.example.tierheim.Application;
import org.example.tierheim.art.adapter.shared.ArtIdMapper;
import org.example.tierheim.art.application.CreateArtUseCase;
import org.example.tierheim.art.application.DeleteArtUseCase;
import org.example.tierheim.art.application.ReadArtUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Component
@RestController
@CrossOrigin(origins = Application.CrossOriginUrl)
@RequestMapping("/api/art")
public class ArtController {

    @Autowired
    private ArtMapper mapper;

    @Autowired
    private CreateArtUseCase create;
    @Autowired
    private DeleteArtUseCase delete;
    @Autowired
    private ReadArtUseCase read;

    @Operation(summary = "listet alle Arten auf")
    @GetMapping()
    public List<ArtReadModel> findAll() {
        return read.findAll()
                .stream()
                .map(mapper::toReadModel)
                .collect(Collectors.toList());
    }

    @Operation(summary = "legt eine neue Art an")
    @PostMapping()
    public ArtReadModel create(@RequestBody final ArtCreateModel art) {
        return mapper.toReadModel(create.execute(mapper.toChanges(art)));
    }

    @Operation(summary = "gibt die gesuchte Art zurück")
    @GetMapping("/{id}")
    public ArtReadModel findById(@PathVariable("id") final UUID id) {
        return mapper.toReadModel(read.findById(ArtIdMapper.fromUuid(id)));
    }

    @Operation(summary = "löscht die gegebene Art")
    @DeleteMapping("/{id}")
    public ArtReadModel delete(@PathVariable("id") final UUID id) {
        return mapper.toReadModel(delete.execute(ArtIdMapper.fromUuid(id)));
    }

    @Operation(summary = "löscht alle Arten")
    @DeleteMapping()
    public void deleteAll() {
        delete.all();
    }

}
