package edu.hillel.lesson24.v2;

import edu.hillel.lesson24.v2.DBConnectionProvider;
import edu.hillel.lesson24.v2.DBStorage;
import edu.hillel.lesson24.v2.FileStorage;
import edu.hillel.lesson24.v2.InMemoryStorage;
import edu.hillel.lesson24.v2.Storage;
import edu.hillel.lesson24.v2.StorageFactory;
import edu.hillel.lesson24.v2.StorageType;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class StorageFactoryTest {

    private StorageFactory storageFactory;

    @Before
    public void setUp() throws Exception {
        storageFactory = new StorageFactory();
    }

    @Test
    public void createStorageInMemory() {
        Storage storage = storageFactory.createStorage(StorageType.IN_MEMORY);
        assertEquals(InMemoryStorage.class, storage.getClass());
    }

    @Test
    public void createStorageDB() {

        DBConnectionProvider dbConnectionProviderMock = Mockito.mock(DBConnectionProvider.class);

        StorageFactory storageFactoryMock = Mockito.mock(StorageFactory.class);

        DBStorage dbStorage = new DBStorage(dbConnectionProviderMock);
        Mockito.when(storageFactoryMock.createStorage(StorageType.DB))
                .thenReturn(dbStorage);


        Storage storage = storageFactoryMock.createStorage(StorageType.DB);
        assertEquals(DBStorage.class, storage.getClass());
    }

    @Test
    public void createStorageFile() {
        Storage storage = storageFactory.createStorage(StorageType.FILE);
        assertEquals(FileStorage.class, storage.getClass());
    }

    @Test
    public void createStorageUnknownType() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            storageFactory.createStorage(StorageType.OTHER);
        });

        assertTrue("Storage type {OTHER} without implementation".equals(exception.getMessage()));
    }
}