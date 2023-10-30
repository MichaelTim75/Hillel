package edu.hillel.lesson24;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class StorageFactoryTest {

    private StorageFactory storageFactory;

    @Before
    public void setUp() throws Exception {
        storageFactory = new StorageFactory();
    }

    @Test
    public void createStorage() {
        Storage storage = storageFactory.createStorage(StorageType.IN_MEMORY);
        assertEquals(InMemoryStorage.class, storage.getClass());
    }

    @Test
    public void createStorageUnknownType() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            storageFactory.createStorage(StorageType.OTHER);
        });

        assertTrue("Storage type {OTHER}without implementation".equals(exception.getMessage()));
    }
}