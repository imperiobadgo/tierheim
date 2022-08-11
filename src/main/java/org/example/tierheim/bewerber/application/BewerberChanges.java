package org.example.tierheim.bewerber.application;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import org.example.tierheim.bewerber.Bewerber;
import org.example.tierheim.shared.Name;

@Value
@Builder
public class BewerberChanges {

    @NonNull
    Name name;

    public Bewerber apply(final Bewerber.BewerberBuilder builder) {
        return builder
                .name(name)
                .build();
    }
}
