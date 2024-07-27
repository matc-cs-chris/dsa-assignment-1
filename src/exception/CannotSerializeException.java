package exception;

public class CannotSerializeException extends Exception {
    public long id;
    public CannotSerializeException(long id, Exception ex) {
        super("Object ID: " + String.valueOf(id) + " could not be serialized.", ex);
        this.id = id;
    }
}
