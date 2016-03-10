package collections;

/**
 * @author Roffe
 * An exception for a queue
 */
public class QueueException extends RuntimeException {
    /**
     * Constructor.
     */
    public QueueException() {}

    /**
     * Constructor.
     * @param message message to display on exception
     */
    public QueueException(String message) {
        super( message );
    }
}
