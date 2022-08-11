package org.example.tierheim.mitarbeiter.application;

public class MitarbeiterNichtVorhandenException extends RuntimeException {

    public MitarbeiterNichtVorhandenException(String message) {
        super(message);
    }
}
