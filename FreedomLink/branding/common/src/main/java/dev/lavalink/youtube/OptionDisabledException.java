package dev.FreedomLink.youtube;

public class OptionDisabledException extends RuntimeException {
    public OptionDisabledException(String message) {
        super(message, null, true, false);
    }
}
