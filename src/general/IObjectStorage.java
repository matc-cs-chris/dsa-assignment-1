package general;

import java.io.Serializable;

public interface IObjectStorage {
    void save(long id, Serializable object);
    Serializable retrieve(long id);
}
