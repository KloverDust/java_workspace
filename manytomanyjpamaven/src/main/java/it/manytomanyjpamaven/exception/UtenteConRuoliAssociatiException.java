package it.manytomanyjpamaven.exception;

public class UtenteConRuoliAssociatiException extends Exception {
    private static final long codiceID = 1L;

    public UtenteConRuoliAssociatiException(String message) {
        super(message);
    }
}
