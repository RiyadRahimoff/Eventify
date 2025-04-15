package az.it.hamburg.eventify.exception;

public class LocationNotFound extends RuntimeException {
    public LocationNotFound(String message) {
        super(message);
    }
}
