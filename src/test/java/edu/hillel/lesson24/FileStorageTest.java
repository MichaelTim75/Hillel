package edu.hillel.lesson24;


import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class FileStorageTest {

    private final StorageFactory storageFactory = new StorageFactory();
    private Storage storage;

    @Before
    public void setUp() {
        storage = storageFactory.createStorage(StorageType.FILE);
        storage.clearData();
    }

    @Test
    public void dataTest() {
        List<String> testData = List.of("first", "second", "third");
        storage.saveData(testData);
        assertEquals(3, storage.getData().size());
        String[] testDataArr = new String[testData.size()];
        testData.toArray(testDataArr);

        String[] getDataArr = new String[storage.getData().size()];
        storage.getData().toArray(getDataArr);

        assertArrayEquals(testDataArr, getDataArr);
    }
}