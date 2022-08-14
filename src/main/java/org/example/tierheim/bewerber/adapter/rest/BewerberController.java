package org.example.tierheim.bewerber.adapter.rest;

import org.example.tierheim.bewerber.adapter.shared.BewerberIdMapper;
import org.example.tierheim.bewerber.application.CreateBewerberUseCase;
import org.example.tierheim.bewerber.application.DeleteBewerberUseCase;
import org.example.tierheim.bewerber.application.EditBewerberUseCase;
import org.example.tierheim.bewerber.application.ReadBewerberUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RestController
@RequestMapping("/api/bewerber")
public class BewerberController {

    @Autowired
    private BewerberMapper mapper;

    @Autowired
    private CreateBewerberUseCase create;
    @Autowired
    private DeleteBewerberUseCase delete;
    @Autowired
    private EditBewerberUseCase edit;
    @Autowired
    private ReadBewerberUseCase read;

    @GetMapping()
    public List<BewerberReadModel> findAll() {
        return read.findAll()
                .stream()
                .map(mapper::toReadModel)
                .collect(Collectors.toList());
    }

    @PostMapping()
    public BewerberReadModel create(@RequestBody final BewerberCreateModel bewerber) {
        return mapper.toReadModel(create.execute(mapper.toChanges(bewerber)));
    }

    @GetMapping("/{id}")
    public BewerberReadModel findById(@PathVariable("id") final UUID id) {
        return mapper.toReadModel(read.findById(BewerberIdMapper.fromUuid(id)));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BewerberReadModel edit(@PathVariable("id") final UUID id, @RequestBody final BewerberWriteModel bewerber) {
        return mapper.toReadModel(
                edit.execute(BewerberIdMapper.fromUuid(id),
                        mapper.toChanges(bewerber))
        );
    }

    @DeleteMapping("/{id}")
    public BewerberReadModel delete(@PathVariable("id") final UUID id) {
        return mapper.toReadModel(delete.execute(BewerberIdMapper.fromUuid(id)));
    }

    @DeleteMapping()
    public void deleteAll() {
        delete.all();
    }

}
