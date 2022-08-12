package org.example.tierheim.reservierungen.adapter.rest;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.UUID;

@Data
@NoArgsConstructor
public class ReservierungCreateModel {

    @NonNull
    UUID bewerberId;

    String notizen;
}
