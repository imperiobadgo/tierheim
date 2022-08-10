package org.example.tierheim.mitarbeiter.adapter.rest;

import lombok.NonNull;
import lombok.Value;

import javax.validation.constraints.Size;
import java.util.UUID;

@Value
public class MitarbeiterWriteModel {

    @NonNull
    UUID id;

    @NonNull
    @Size(min = 1, max = 50)
    String name;
}
