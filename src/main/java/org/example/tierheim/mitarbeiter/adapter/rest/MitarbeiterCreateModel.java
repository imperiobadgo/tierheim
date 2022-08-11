package org.example.tierheim.mitarbeiter.adapter.rest;

import lombok.*;

import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class MitarbeiterCreateModel {

    @NonNull
    @Size(min = 2, max = 50)
    String name;

}
