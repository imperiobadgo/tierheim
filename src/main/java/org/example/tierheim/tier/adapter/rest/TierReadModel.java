package org.example.tierheim.tier.adapter.rest;

import lombok.Value;
import org.example.tierheim.tier.Geschlecht;
import org.example.tierheim.tier.TierStatus;

import java.util.UUID;

import static org.example.tierheim.tier.Geschlecht.UNBEKANNT;
import static org.example.tierheim.tier.TierStatus.OFFEN;

@Value
public class TierReadModel {

    UUID id;

    TierStatus status = OFFEN;

    Geschlecht geschlecht = UNBEKANNT;

    String name;

    UUID art;

    UUID reservierung;

}
