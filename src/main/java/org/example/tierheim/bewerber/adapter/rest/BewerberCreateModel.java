package org.example.tierheim.bewerber.adapter.rest;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class BewerberCreateModel {

    @NonNull
    @Size(min = 2, max = 50)
    String name;

}
