package org.example.tierheim.mitarbeiter;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import org.example.tierheim.shared.Name;

import java.util.UUID;

@Value
@Builder(toBuilder = true)
public class Mitarbeiter {

    @NonNull
    @Builder.Default
    MitarbeiterId id = new MitarbeiterId(UUID.randomUUID());

    @Builder.Default
    long version = 0;

    @NonNull
    Name name;

}
