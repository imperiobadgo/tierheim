package org.example.tierheim;

import lombok.NonNull;
import lombok.Value;

import java.util.UUID;

@Value
public class TierId {

    @NonNull
    UUID value;

    @Override
    public String toString() {
        return value.toString();
    }

}