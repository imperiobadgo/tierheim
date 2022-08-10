package org.example.tierheim.mitarbeiter.adapter.rest;

import org.example.tierheim.mitarbeiter.adapter.shared.MitarbeiterIdMapper;
import org.example.tierheim.mitarbeiter.application.CreateMitarbeiterUseCase;
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

    @GetMapping("/mitarbeiter")
    public List<MitarbeiterReadModel> findAll() {
        return read.findAll()
                .stream()
                .map(mapper::toReadModel)
                .collect(Collectors.toList());
    }

    @PostMapping("/mitarbeiter")
    public void save(@RequestBody MitarbeiterWriteModel mitarbeiter) {
        create.execute(mapper.toChanges(mitarbeiter));
    }

    @GetMapping("/mitarbeiter/{id}")
    public MitarbeiterReadModel findById(@PathVariable("id") final UUID id) {
        return mapper.toReadModel(read.getById(MitarbeiterIdMapper.fromUuid(id)));
    }

    @PutMapping("/mitarbeiter/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MitarbeiterReadModel edit(@PathVariable("id") final UUID id, @RequestBody final MitarbeiterWriteModel mitarbeiter) {
        return mapper.toReadModel(
                edit.execute(MitarbeiterIdMapper.fromUuid(id),
                mapper.toChanges(mitarbeiter))
        );
    }
}
