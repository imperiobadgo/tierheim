package org.example.tierheim.tier.adapter.rest;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.example.tierheim.tier.Geschlecht;
import org.example.tierheim.tier.TierStatus;

import java.util.UUID;

import static org.example.tierheim.tier.Geschlecht.UNBEKANNT;
import static org.example.tierheim.tier.TierStatus.OFFEN;

@Data
@NoArgsConstructor
public class TierCreateModel {

    TierStatus status = OFFEN;

    @NonNull
    Geschlecht geschlecht = UNBEKANNT;

    @NonNull
    String name;

    UUID art;

    UUID reservierung;

}
