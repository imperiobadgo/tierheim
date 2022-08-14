package org.example.tierheim.art;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import org.example.tierheim.shared.Name;

import java.util.UUID;

@Value
@Builder(toBuilder = true)
public class Art {

    @NonNull
    @Builder.Default
    ArtId id = new ArtId(UUID.randomUUID());

    @Builder.Default
    long version = 0;

    @NonNull
    Name name;

}
