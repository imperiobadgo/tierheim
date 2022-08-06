package org.example.tierheim.shared;

import lombok.Value;

@Value
public class Name {

    public static Name of(final String value) {
        return new Name(value);
    }

    public static boolean isValid(final String value) {
        return value != null && !value.isEmpty() && !value.isBlank();
    }

    String value;

    private Name(final String value) {
        if (isValid(value)) {
            this.value = value.trim();
        } else {
            throw new IllegalArgumentException("Invalid name.");
        }
    }

    @Override
    public String toString() {
        return value;
    }

}
