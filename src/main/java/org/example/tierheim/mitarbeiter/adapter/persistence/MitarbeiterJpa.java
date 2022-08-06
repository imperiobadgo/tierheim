package org.example.tierheim.mitarbeiter.adapter.persistence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
class MitarbeiterJpa {

    @Id
    @Column
    UUID id;

    @Version
    @Column
    long version;

    @Column
    String name;

}
