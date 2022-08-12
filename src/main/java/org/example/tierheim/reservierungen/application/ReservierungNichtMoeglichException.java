package org.example.tierheim.reservierungen.application;

import org.example.tierheim.TierStatus;

public class ReservierungNichtMoeglichException extends RuntimeException {

    private static String createMessage(TierStatus status) {
        switch (status) {
            case RESERVIERT:
                return "Eine Reservierung ist schon vorhanden!";
            case ABGEGEBEN:
                return "Das Tier ist bereits abgeben!";
            case GESTORBEN:
                return "Das Tier ist gestorben!";
            default:
                return "Die Reservierung ist nicht möglich!";
        }
    }

    public ReservierungNichtMoeglichException(TierStatus status) {
        super(createMessage(status));
    }

}
