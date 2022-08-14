package org.example.tierheim.reservierungen.adapter.rest;

import org.example.tierheim.reservierungen.adapter.shared.ReservierungIdMapper;
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
    private EditReservierungUseCase edit;
    @Autowired
    private ReadReservierungUseCase read;

    @GetMapping()
    public List<ReservierungReadModel> findAll() {
        return read.findAll()
                .stream()
                .map(mapper::toReadModel)
                .collect(Collectors.toList());
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
}
