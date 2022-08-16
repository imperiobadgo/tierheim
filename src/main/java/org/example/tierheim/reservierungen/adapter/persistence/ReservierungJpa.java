package org.example.tierheim.reservierungen.adapter.persistence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Type;

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
class ReservierungJpa {

    @Id
    @Column
    @Type(type = "uuid-char")//To make sure UUID is stored as string not binary, because binary can't be read properly, apparently.
    UUID id;

    @Version
    @Column
    long version;

    @Column
    UUID bewerberId;

    @Column
    String notizen;
}
