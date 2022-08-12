package org.example.tierheim.reservierungen.adapter.rest;

import lombok.NonNull;
import lombok.Value;

import java.util.UUID;

@Value
public class ReservierungReadModel {

    @NonNull
    UUID bewerberId;

    @NonNull
    String notizen;
}
