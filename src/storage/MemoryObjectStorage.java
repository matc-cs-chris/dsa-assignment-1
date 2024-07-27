package storage;

import exception.CannotSerializeException;
import exception.NoObjectFoundException;
import exception.SaveFailedException;
import general.ObjectStorage;
import util.ByteUtilities;

import java.io.Serializable;
import java.util.HashMap;

public class MemoryObjectStorage extends ObjectStorage {
    private HashMap<Long, Byte[]> storage = new HashMap<>();

    @Override
    public long[] getStoredIDs() {
        long[] result = new long[storage.size()];

        int index = 0;
        for(long key : storage.keySet()) {
            result[index] = key;
        }

        return result;
    }

    @Override
    public void save(long id, Serializable object) throws SaveFailedException {
        try {
            byte[] storedState = serialize(id, object);
            storage.put(id, ByteUtilities.toObjectArray(storedState));
        }
        catch (CannotSerializeException ex) {
            throw new SaveFailedException(id, ex);
        }
    }

    @Override
    public Object retrieve(long id) throws NoObjectFoundException {
        if(storage.containsKey(id)) {
            return storage.get(id);
        }
        else throw new NoObjectFoundException(id, new Exception("ID not found in memory"));
    }
}
