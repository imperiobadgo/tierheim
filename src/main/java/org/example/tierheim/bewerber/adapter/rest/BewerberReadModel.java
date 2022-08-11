package org.example.tierheim.bewerber.adapter.rest;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class BewerberReadModel {

    UUID id;

    String name;

}
