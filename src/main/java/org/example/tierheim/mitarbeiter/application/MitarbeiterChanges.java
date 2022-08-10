package org.example.tierheim.mitarbeiter.application;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import org.example.tierheim.shared.Name;
import org.example.tierheim.mitarbeiter.Mitarbeiter;

@Value
@Builder
public class MitarbeiterChanges {

    @NonNull
    Name name;

    public Mitarbeiter apply(final Mitarbeiter.MitarbeiterBuilder builder) {
        return builder
                .name(name)
                .build();
    }

}
