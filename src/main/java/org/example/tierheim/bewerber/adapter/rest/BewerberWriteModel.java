package org.example.tierheim.bewerber.adapter.rest;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.Size;
import java.util.UUID;

@Data
@NoArgsConstructor
public class BewerberWriteModel {

    @NonNull
    UUID id;

    @NonNull
    @Size(min = 2, max = 50)
    String name;
}
