package org.example.tierheim.bewerber;

import lombok.NonNull;
import lombok.Value;

import java.util.UUID;

@Value
public class BewerberId {

    @NonNull
    UUID value;

    @Override
    public String toString() {
        return value.toString();
    }

}
