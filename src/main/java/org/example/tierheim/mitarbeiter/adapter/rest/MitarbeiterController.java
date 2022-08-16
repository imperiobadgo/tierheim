package org.example.tierheim.mitarbeiter.adapter.rest;

import io.swagger.v3.oas.annotations.Operation;
import org.example.tierheim.mitarbeiter.adapter.shared.MitarbeiterIdMapper;
import org.example.tierheim.mitarbeiter.application.CreateMitarbeiterUseCase;
import org.example.tierheim.mitarbeiter.application.DeleteMitarbeiterUseCase;
import org.example.tierheim.mitarbeiter.application.EditMitarbeiterUseCase;
import org.example.tierheim.mitarbeiter.application.ReadMitarbeiterUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RestController
@RequestMapping("/api/mitarbeiter")
public class MitarbeiterController {

    @Autowired
    private MitarbeiterMapper mapper;

    @Autowired
    private CreateMitarbeiterUseCase create;
    @Autowired
    private EditMitarbeiterUseCase edit;
    @Autowired
    private ReadMitarbeiterUseCase read;
    @Autowired
    private DeleteMitarbeiterUseCase delete;

    @Operation(summary = "listet alle Mitarbeiter auf")
    @GetMapping()
    public List<MitarbeiterReadModel> findAll() {
        return read.findAll()
                .stream()
                .map(mapper::toReadModel)
                .collect(Collectors.toList());
    }

    @Operation(summary = "legt einen neuen Mitarbeiter an")
    @PostMapping()
    public MitarbeiterReadModel create(@RequestBody final MitarbeiterCreateModel mitarbeiter) {
        return mapper.toReadModel(create.execute(mapper.toChanges(mitarbeiter)));
    }

    @Operation(summary = "gibt den gesuchten Mitarbeiter zurück")
    @GetMapping("/{id}")
    public MitarbeiterReadModel findById(@PathVariable("id") final UUID id) {
        return mapper.toReadModel(read.findById(MitarbeiterIdMapper.fromUuid(id)));
    }

    @Operation(summary = "editiert den gegebenen Mitarbeiter")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MitarbeiterReadModel edit(@PathVariable("id") final UUID id, @RequestBody final MitarbeiterWriteModel mitarbeiter) {
        return mapper.toReadModel(
                edit.execute(MitarbeiterIdMapper.fromUuid(id),
                mapper.toChanges(mitarbeiter))
        );
    }

    @Operation(summary = "löscht den gegebenen Mitarbeiter")
    @DeleteMapping("/{id}")
    public MitarbeiterReadModel delete(@PathVariable("id") final UUID id) {
        return mapper.toReadModel(delete.execute(MitarbeiterIdMapper.fromUuid(id)));
    }

    @Operation(summary = "löscht alle Mitarbeiter")
    @DeleteMapping()
    public void deleteAll() {
        delete.all();
    }

}
