package exception;

public class NoObjectFoundException extends Exception {
    public long id;
    public NoObjectFoundException(long id, Exception ex) {
        super("Object ID: " + String.valueOf(id) + " was not found in storage.", ex);
        this.id = id;
    }
}
