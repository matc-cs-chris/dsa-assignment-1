package storage;

import exception.CannotSerializeException;
import exception.NoObjectFoundException;
import exception.SaveFailedException;
import general.ObjectStorage;

import java.io.*;

public class FileObjectStorage extends ObjectStorage {
    private String folderName = "save";
    private String extension = ".ser";

    public FileObjectStorage() {}
    public FileObjectStorage(String folderName) {
        this.folderName = folderName;
    }

    public FileObjectStorage(String folderName, String extension) {
        this(folderName);
        this.extension = extension;
    }

    @Override
    public long[] getStoredIDs() {
        File saveFolder = new File(folderName);
        long[] result;

        if(saveFolder.isDirectory()) {
            File[] storedFiles = saveFolder.listFiles();
            result = new long[storedFiles.length];

            for(int i = 0; i < storedFiles.length;i++) {
                String name = storedFiles[i].getName();

                //get the long number from the file name (without .ser extension)
                result[i] = Long.getLong(name.substring(0, name.indexOf('.')));
            }

            return result;
        }
        else return new long[0];
    }

    @Override
    public void save(long id, Serializable object) throws SaveFailedException {
        //example of try/catch syntax that closes output/input streams automatically
        try( FileOutputStream fileOut = new FileOutputStream(folderName + File.separator +
                        String.valueOf(id) + extension);) {
            fileOut.write(serialize(id, object));
        }
        catch (CannotSerializeException | IOException ex) {
            throw new SaveFailedException(id, ex);
        }
    }

    @Override
    public Object retrieve(long id) throws NoObjectFoundException {
        try( FileInputStream fileIn = new FileInputStream(folderName + File.separator +
                        String.valueOf(id) + extension); ObjectInputStream in = new ObjectInputStream(fileIn)) {
            return in.readObject();
        }
        catch (ClassNotFoundException | IOException ex) {
            throw new NoObjectFoundException(id, ex);
        }
    }
}
