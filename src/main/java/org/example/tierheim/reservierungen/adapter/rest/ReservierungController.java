package org.example.tierheim.reservierungen.adapter.rest;

import org.example.tierheim.mitarbeiter.adapter.rest.MitarbeiterCreateModel;
import org.example.tierheim.mitarbeiter.adapter.rest.MitarbeiterMapper;
import org.example.tierheim.mitarbeiter.adapter.rest.MitarbeiterReadModel;
import org.example.tierheim.mitarbeiter.adapter.rest.MitarbeiterWriteModel;
import org.example.tierheim.mitarbeiter.adapter.shared.MitarbeiterIdMapper;
import org.example.tierheim.mitarbeiter.application.CreateMitarbeiterUseCase;
import org.example.tierheim.mitarbeiter.application.DeleteMitarbeiterUseCase;
import org.example.tierheim.mitarbeiter.application.EditMitarbeiterUseCase;
import org.example.tierheim.mitarbeiter.application.ReadMitarbeiterUseCase;
import org.example.tierheim.reservierungen.ReservierungId;
import org.example.tierheim.reservierungen.adapter.shared.ReservierungIdMapper;
import org.example.tierheim.reservierungen.application.CreateReservierungUseCase;
import org.example.tierheim.reservierungen.application.DeleteReservierungUseCase;
import org.example.tierheim.reservierungen.application.EditReservierungUseCase;
import org.example.tierheim.reservierungen.application.ReadReservierungUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RestController
@RequestMapping("/api/reservierungen")
public class ReservierungController {

    @Autowired
    private ReservierungMapper mapper;

    @Autowired
    private CreateReservierungUseCase create;
    @Autowired
    private EditReservierungUseCase edit;
    @Autowired
    private ReadReservierungUseCase read;
    @Autowired
    private DeleteReservierungUseCase delete;

    @GetMapping()
    public List<ReservierungReadModel> findAll() {
        return read.findAll()
                .stream()
                .map(mapper::toReadModel)
                .collect(Collectors.toList());
    }

    @PostMapping()
    public ReservierungReadModel create(@RequestBody final ReservierungCreateModel reservierung) {
        return mapper.toReadModel(create.execute(mapper.toChanges(reservierung)));
    }

    @GetMapping("/{id}")
    public ReservierungReadModel findById(@PathVariable("id") final UUID id) {
        return mapper.toReadModel(read.findById(ReservierungIdMapper.fromUuid(id)));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ReservierungReadModel edit(@PathVariable("id") final UUID id, @RequestBody final ReservierungWriteModel reservierung) {
        return mapper.toReadModel(
                edit.execute(ReservierungIdMapper.fromUuid(id),
                        mapper.toChanges(reservierung))
        );
    }

    @DeleteMapping("/{id}")
    public ReservierungReadModel delete(@PathVariable("id") final UUID id) {
        return mapper.toReadModel(delete.execute(ReservierungIdMapper.fromUuid(id)));
    }

    @DeleteMapping()
    public void deleteAll() {
        delete.all();
    }

}
