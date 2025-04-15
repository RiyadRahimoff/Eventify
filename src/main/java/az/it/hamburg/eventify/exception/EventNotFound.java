package az.it.hamburg.eventify.exception;

public class EventNotFound extends RuntimeException{
    public EventNotFound(String message) {
        super(message);
    }
}
