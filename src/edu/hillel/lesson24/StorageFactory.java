package edu.hillel.lesson24;

public class StorageFactory {

    public Storage createStorage(StorageType type) {
        switch (type) {
            case DB -> {
                return new DBStorage();
            }
            case FILE -> {
                return new FileStorage();
            }
            case IN_MEMORY -> {
                return new InMemoryStorage();
            }
        }
        throw new RuntimeException("Storage type {" + type + "}without implementation");
    }


}
