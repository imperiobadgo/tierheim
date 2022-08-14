package org.example.tierheim.tier.adapter.rest;

import org.example.tierheim.bewerber.adapter.shared.BewerberIdMapper;
import org.example.tierheim.tier.adapter.shared.TierIdMapper;
import org.example.tierheim.tier.application.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RestController
@RequestMapping("/api/tier")
public class TierController {

    @Autowired
    private TierMapper mapper;

    @Autowired
    private CreateTierUseCase create;
    @Autowired
    private EditTierUseCase edit;
    @Autowired
    private ReadTierUseCase read;
    @Autowired
    private DeleteTierUseCase delete;

    @Autowired
    private TierReservierenUseCase reservieren;

    @Autowired
    private ReservierungStornierenUseCase stornieren;

    @GetMapping()
    public List<TierReadModel> findAll() {
        return read.findAll()
                .stream()
                .map(mapper::toReadModel)
                .collect(Collectors.toList());
    }

    @PostMapping()
    public TierReadModel create(@RequestBody final TierCreateModel input) {
        return mapper.toReadModel(create.execute(mapper.toChanges(input)));
    }

    @GetMapping("/{id}")
    public TierReadModel findById(@PathVariable("id") final UUID id) {
        return mapper.toReadModel(read.findById(TierIdMapper.fromUuid(id)));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TierReadModel edit(@PathVariable("id") final UUID id, @RequestBody final TierWriteModel input) {
        return mapper.toReadModel(
                edit.execute(TierIdMapper.fromUuid(id),
                        mapper.toChanges(input))
        );
    }

    @PutMapping("/{id}/{bewerberId}")
    @ResponseStatus(HttpStatus.OK)
    public TierReadModel reservieren(@PathVariable("id") final UUID id, @PathVariable("bewerberId") final UUID bewerberId){
        return mapper.toReadModel(
                reservieren.execute(TierIdMapper.fromUuid(id), BewerberIdMapper.fromUuid(bewerberId))
        );
    }

    @DeleteMapping("/{id}/{bewerberId}")
    @ResponseStatus(HttpStatus.OK)
    public TierReadModel stornieren(@PathVariable("id") final UUID id, @PathVariable("bewerberId") final UUID bewerberId){
        return mapper.toReadModel(
                stornieren.execute(TierIdMapper.fromUuid(id), BewerberIdMapper.fromUuid(bewerberId))
        );
    }

    @DeleteMapping("/{id}")
    public TierReadModel delete(@PathVariable("id") final UUID id) {
        return mapper.toReadModel(delete.execute(TierIdMapper.fromUuid(id)));
    }

    @DeleteMapping()
    public void deleteAll() {
        delete.all();
    }

}
