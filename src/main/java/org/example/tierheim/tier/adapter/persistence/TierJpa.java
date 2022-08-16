package org.example.tierheim.tier.adapter.persistence;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.tierheim.tier.Geschlecht;
import org.example.tierheim.tier.TierStatus;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;
import static org.example.tierheim.tier.Geschlecht.UNBEKANNT;
import static org.example.tierheim.tier.TierStatus.OFFEN;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
class TierJpa {

    @Id
    @Column
    @Type(type = "uuid-char")//To make sure UUID is stored as string not binary, because binary can't be read properly, apparently.
    UUID id;

    @Version
    @Column
    long version;

    @NonNull
    @Enumerated(EnumType.STRING)
    TierStatus status = OFFEN;

    @NonNull
    @Enumerated(EnumType.STRING)
    Geschlecht geschlecht = UNBEKANNT;

    @NonNull
    String name;

    UUID art;

    UUID reservierung;


}
