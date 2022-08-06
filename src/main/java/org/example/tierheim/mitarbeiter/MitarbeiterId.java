package org.example.tierheim.mitarbeiter;

import lombok.NonNull;
import lombok.Value;

import java.util.UUID;

@Value
public class MitarbeiterId {

    @NonNull
    UUID value;

    @Override
    public String toString() {
        return value.toString();
    }

}
