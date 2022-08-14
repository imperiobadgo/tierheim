package org.example.tierheim.art.adapter.rest;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class ArtReadModel {

    UUID id;

    String name;
}
