package edu.hillel.lesson24.v2;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class DBStorageTest {

    private final DataDAO dataDAOMock = Mockito.mock(DataDAO.class);

    private DBConnectionProvider dbConnectionProviderMock = Mockito.mock(DBConnectionProvider.class);

    private final StorageFactory storageFactoryMock = Mockito.mock(StorageFactory.class);

    private Storage storage;

    @Before
    public void setUp() {
        Mockito.when(dbConnectionProviderMock.getDataDAO())
                .thenReturn(dataDAOMock);

        DBStorage dbStorage = new DBStorage(dbConnectionProviderMock);
        Mockito.when(storageFactoryMock.createStorage(StorageType.DB))
                .thenReturn(dbStorage);

        storage = storageFactoryMock.createStorage(StorageType.DB);

    }

    @Test
    public void dataTest() {
        List<String> testData = List.of("first", "second", "third");

        Mockito.when(dataDAOMock.addData(testData)).thenReturn(new int[]{1, 1, 1});
        Mockito.when(dataDAOMock.getData()).thenReturn(testData);

        storage.saveData(testData);
        assertEquals(3, storage.getData().size());
        String[] testDataArr = new String[testData.size()];
        testData.toArray(testDataArr);

        String[] getDataArr = new String[storage.getData().size()];
        storage.getData().toArray(getDataArr);

        assertArrayEquals(testDataArr, getDataArr);
    }
}