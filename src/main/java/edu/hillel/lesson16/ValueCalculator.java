package edu.hillel.lesson16;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class ValueCalculator {
    private float[] array;
    private static final int ARRAY_SIZE = 10000000;
    private static final int HALF_ARRAY_SIZE = ARRAY_SIZE / 2;
    private static final int FIFTH_ARRAY_SIZE = ARRAY_SIZE / 5;

    public long method(boolean needSynchro) {
        long start = System.currentTimeMillis();

        array = new float[ARRAY_SIZE];

        for (int i = 0; i < ARRAY_SIZE; i++) {
            array[i] = 1;
        }
        float[] arr1 = new float[HALF_ARRAY_SIZE];
        float[] arr2 = new float[HALF_ARRAY_SIZE];
        float[] arr3 = new float[HALF_ARRAY_SIZE];
        float[] arr4 = new float[HALF_ARRAY_SIZE];
        float[] arr5 = new float[HALF_ARRAY_SIZE];

        System.arraycopy(array, 0, arr1, 0, FIFTH_ARRAY_SIZE);
        System.arraycopy(array, FIFTH_ARRAY_SIZE, arr2, 0, FIFTH_ARRAY_SIZE);
        System.arraycopy(array, 2 * FIFTH_ARRAY_SIZE, arr3, 0, FIFTH_ARRAY_SIZE);
        System.arraycopy(array, 3 * FIFTH_ARRAY_SIZE, arr4, 0, FIFTH_ARRAY_SIZE);
        System.arraycopy(array, 4 * FIFTH_ARRAY_SIZE, arr5, 0, FIFTH_ARRAY_SIZE);

        CyclicBarrier meetingPoint = new CyclicBarrier(6);

        ReCalcArray reCalcArray1 = new ReCalcArray(arr1, needSynchro, meetingPoint);
        Thread thread1 = new Thread(reCalcArray1, "recalculation array 1");
        thread1.start();

        ReCalcArray reCalcArray2 = new ReCalcArray(arr2, needSynchro, meetingPoint);
        Thread thread2 = new Thread(reCalcArray2, "recalculation array 2");
        thread2.start();

        ReCalcArray reCalcArray3 = new ReCalcArray(arr3, needSynchro, meetingPoint);
        Thread thread3 = new Thread(reCalcArray3, "recalculation array 3");
        thread3.start();

        ReCalcArray reCalcArray4 = new ReCalcArray(arr4, needSynchro, meetingPoint);
        Thread thread4 = new Thread(reCalcArray4, "recalculation array 4");
        thread4.start();

        ReCalcArray reCalcArray5 = new ReCalcArray(arr5, needSynchro, meetingPoint);
        Thread thread5 = new Thread(reCalcArray5, "recalculation array 5");
        thread5.start();

        try {
            meetingPoint.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }

        System.arraycopy(arr1, 0, array, 0, FIFTH_ARRAY_SIZE);
        System.arraycopy(arr2, 0, array, FIFTH_ARRAY_SIZE, FIFTH_ARRAY_SIZE);
        System.arraycopy(arr3, 0, array, 2 * FIFTH_ARRAY_SIZE, FIFTH_ARRAY_SIZE);
        System.arraycopy(arr4, 0, array, 3 * FIFTH_ARRAY_SIZE, FIFTH_ARRAY_SIZE);
        System.arraycopy(arr5, 0, array, 4 * FIFTH_ARRAY_SIZE, FIFTH_ARRAY_SIZE);

        return System.currentTimeMillis() - start;
    }
}
