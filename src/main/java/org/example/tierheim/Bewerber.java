package org.example.tierheim;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import org.example.tierheim.shared.Name;

import java.util.UUID;

@Value
@Builder
public class Bewerber {

    @NonNull
    @Builder.Default
    BewerberId id = new BewerberId(UUID.randomUUID());

    @NonNull
    Name name;
}
