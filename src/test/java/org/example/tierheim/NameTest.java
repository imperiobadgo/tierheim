package org.example.tierheim;

import org.example.tierheim.shared.Name;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NameTest {

    @Test
    void of_withValidValue_returnsName() {
        final Name name = Name.of("Max");
        assertEquals("Max", name.getValue());
    }

    @Test
    void of_withLeadingSpaces_returnsNameWithoutLeadingSpaces() {
        final Name name = Name.of("  Erika ");
        assertEquals("Erika", name.getValue());
    }

    @ParameterizedTest
    @ValueSource(strings = { "", " " })
    void of_withInvalidValues_throwsIllegalArgumentException(final String value) {
        assertThrows(IllegalArgumentException.class, () -> Name.of(value));
    }

}
