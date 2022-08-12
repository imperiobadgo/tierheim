package org.example.tierheim.reservierungen;

import lombok.NonNull;
import lombok.Value;

import java.util.UUID;

@Value
public class ReservierungId {

    @NonNull
    UUID value;

    @Override
    public String toString() {
        return value.toString();
    }

}
