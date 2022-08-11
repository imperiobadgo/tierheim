package org.example.tierheim.mitarbeiter.adapter.rest;

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

    @GetMapping()
    public List<MitarbeiterReadModel> findAll() {
        return read.findAll()
                .stream()
                .map(mapper::toReadModel)
                .collect(Collectors.toList());
    }

    @PostMapping()
    public MitarbeiterReadModel create(@RequestBody final MitarbeiterCreateModel mitarbeiter) {
        return mapper.toReadModel(create.execute(mapper.toChanges(mitarbeiter)));
    }

    @GetMapping("/{id}")
    public MitarbeiterReadModel findById(@PathVariable("id") final UUID id) {
        return mapper.toReadModel(read.findById(MitarbeiterIdMapper.fromUuid(id)));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MitarbeiterReadModel edit(@PathVariable("id") final UUID id, @RequestBody final MitarbeiterWriteModel mitarbeiter) {
        return mapper.toReadModel(
                edit.execute(MitarbeiterIdMapper.fromUuid(id),
                mapper.toChanges(mitarbeiter))
        );
    }

    @DeleteMapping("/{id}")
    public MitarbeiterReadModel delete(@PathVariable("id") final UUID id) {
        return mapper.toReadModel(delete.execute(MitarbeiterIdMapper.fromUuid(id)));
    }

    @DeleteMapping()
    public void deleteAll() {
        delete.all();
    }

}
