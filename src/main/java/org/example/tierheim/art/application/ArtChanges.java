package org.example.tierheim.art.application;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import org.example.tierheim.art.Art;
import org.example.tierheim.shared.Name;

@Value
@Builder
public class ArtChanges {

    @NonNull
    Name name;

    public Art apply(final Art.ArtBuilder builder) {
        return builder
                .name(name)
                .build();
    }
}
