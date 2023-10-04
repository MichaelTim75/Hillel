package edu.hillel.lesson16;

import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

public class ValueCalculator {
    private float[] array;
    private static final int ARRAY_SIZE=10000000;
    private static final int HALF_ARRAY_SIZE=ARRAY_SIZE/2;

    public long method (boolean needSynchro)  {
        long start = System.currentTimeMillis();

        array=new float[ARRAY_SIZE];

        for (int i = 0; i <ARRAY_SIZE ; i++) {
            array[i]=1;
        }
        float[] arr1=new float[HALF_ARRAY_SIZE];
        float[] arr2=new float[HALF_ARRAY_SIZE];

        System.arraycopy(array,0,arr1,0,HALF_ARRAY_SIZE);
        System.arraycopy(array,HALF_ARRAY_SIZE,arr2,0,HALF_ARRAY_SIZE);

        ReCalcArray reCalcArray1 = new ReCalcArray(arr1,needSynchro);
        Thread thread1= new Thread(reCalcArray1, "recalculation array 1");
        thread1.start();

        ReCalcArray reCalcArray2 = new ReCalcArray(arr2,needSynchro);
        Thread thread2 = new Thread(reCalcArray2, "recalculation array 2");
        thread2.start();

        try {
            thread1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.arraycopy(arr1,0,array,0,HALF_ARRAY_SIZE);
        System.arraycopy(arr2,0,array,HALF_ARRAY_SIZE,HALF_ARRAY_SIZE);

//        System.out.println("Execution time="+(System.currentTimeMillis()-start)+"ms");
        return System.currentTimeMillis()-start;
    }
}
