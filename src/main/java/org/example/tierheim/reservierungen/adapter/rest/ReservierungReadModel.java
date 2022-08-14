package org.example.tierheim.reservierungen.adapter.rest;

import lombok.Value;

import java.util.UUID;

@Value
public class ReservierungReadModel {

    UUID id;

    UUID bewerberId;

    String notizen;
}
