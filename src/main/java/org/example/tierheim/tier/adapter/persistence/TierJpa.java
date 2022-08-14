package org.example.tierheim.tier.adapter.persistence;

import lombok.NonNull;
import org.example.tierheim.tier.Geschlecht;
import org.example.tierheim.tier.TierStatus;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Version;
import java.util.UUID;

import static org.example.tierheim.tier.Geschlecht.UNBEKANNT;
import static org.example.tierheim.tier.TierStatus.OFFEN;

class TierJpa {

    @Id
    @Column
    @Type(type = "uuid-char")//To make sure UUID is stored as string not binary, because binary can't be read properly, apparently.
    UUID id;

    @Version
    @Column
    long version;

    @NonNull
    TierStatus status = OFFEN;

    @NonNull
    Geschlecht geschlecht = UNBEKANNT;

    @NonNull
    String name;

    UUID art;

    UUID reservierung;


}
