package org.example.tierheim.reservierungen.adapter.rest;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.UUID;

@Data
@NoArgsConstructor
public class ReservierungWriteModel {

    @NonNull
    UUID id;

    @NonNull
    UUID bewerberId;

    @NonNull
    String notizen;
}
