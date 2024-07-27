package storage;

import general.IObjectStorage;

import java.io.*;

public class FileObjectStorage implements IObjectStorage {
    private String folderName = "save";
    private String extension = ".sav";

    public FileObjectStorage() {}
    public FileObjectStorage(String folderName) {
        this.folderName = folderName;
    }

    public FileObjectStorage(String folderName, String extension) {
        this(folderName);
        this.extension = extension;
    }
    @Override
    public void save(long id, Serializable object) {
        try(
                FileOutputStream fileOut = new FileOutputStream(folderName + File.separator +
                        String.valueOf(id) + extension);
                ObjectOutputStream objOut = new ObjectOutputStream(fileOut)) {
            //TODO

        }
        catch (FileNotFoundException ex) {

        }
        catch (IOException ex) {

        }
    }

    @Override
    public Serializable retrieve(long id) {
        return null;
    }
}
