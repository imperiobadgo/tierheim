package org.example.tierheim.mitarbeiter.adapter.rest;

import lombok.Value;

import java.util.UUID;

@Value
public class MitarbeiterReadModel {

    UUID id;

    String name;
}
