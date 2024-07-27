package general;

import exception.CannotSerializeException;

import java.io.*;

public abstract class ObjectStorage implements IObjectStorage {
    /**
     * to be honest, you'd normally just write to a file output stream or a socket
     * but I'm doing it this way to demonstrate uses of inheritance
     *
     * @param id a unique id to refer to a saved object
     * @param object the object to save
     * @return a byte array representing the object
     * @throws CannotSerializeException
     */
    public byte[] serialize(long id, Serializable object) throws CannotSerializeException {
        try (
            ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
                ObjectOutputStream out = new ObjectOutputStream(byteOut);)
        {
            out.writeObject(object);
            return byteOut.toByteArray();
        } catch (IOException ex) {
            throw new CannotSerializeException(id, ex);
        }
    }
}
