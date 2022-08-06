package org.example.tierheim.shared;

public class NameMapper {

    public static Name fromString(final String value) {
        return Name.of(value);
    }

    public static String toString(final Name name) {
        return name.getValue();
    }

    private NameMapper() {
        throw new AssertionError();
    }

}
