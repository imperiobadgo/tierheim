package org.example.tierheim.art.adapter.rest;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class ArtCreateModel {

    @NonNull
    @Size(min = 2, max = 50)
    String name;

}
