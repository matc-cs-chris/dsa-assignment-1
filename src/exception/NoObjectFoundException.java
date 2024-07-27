package exception;

public class NoObjectFoundException extends Exception {
    public NoObjectFoundException(long id, Exception ex) {
        super("Object ID: " + String.valueOf(id) + " was not found in storage.", ex);
    }
}
