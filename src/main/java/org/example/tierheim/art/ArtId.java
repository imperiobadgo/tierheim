package org.example.tierheim.art;

import lombok.NonNull;
import lombok.Value;

import java.util.UUID;

@Value
public class ArtId {

    @NonNull
    UUID value;

    @Override
    public String toString() {
        return value.toString();
    }

}
