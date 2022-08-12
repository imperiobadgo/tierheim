package org.example.tierheim.reservierungen.application;

public class ReservierungNichtVorhandenException extends RuntimeException {

    public ReservierungNichtVorhandenException(String message) {
        super(message);
    }
}
