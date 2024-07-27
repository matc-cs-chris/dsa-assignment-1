package exception;

public class SaveFailedException extends Exception {
    public SaveFailedException(long id, Exception ex) {
        super("Object ID: " + String.valueOf(id) + " could not be saved.", ex);
    }
}