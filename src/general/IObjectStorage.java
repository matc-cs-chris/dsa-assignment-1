package general;

import exception.NoObjectFoundException;
import exception.SaveFailedException;

import java.io.Serializable;

public interface IObjectStorage {
    long[] getStoredIDs();
    void save(long id, Serializable object) throws SaveFailedException;
    Object retrieve(long id) throws NoObjectFoundException;
}
