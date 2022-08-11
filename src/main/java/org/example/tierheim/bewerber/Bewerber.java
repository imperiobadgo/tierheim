package org.example.tierheim.bewerber;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import org.example.tierheim.shared.Name;

import java.util.UUID;

@Value
@Builder(toBuilder = true)
public class Bewerber {

    @NonNull
    @Builder.Default
    BewerberId id = new BewerberId(UUID.randomUUID());

    @NonNull
    Name name;
}
