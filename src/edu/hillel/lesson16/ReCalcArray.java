package edu.hillel.lesson16;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class ReCalcArray implements Runnable {
    private final float[] array;
    private final boolean needSynchro;
    private final CyclicBarrier barrier;
    private final String name;

    public ReCalcArray(float[] array, boolean needSynchro, CyclicBarrier barrier, String name) {
        this.array = array;
        this.needSynchro = needSynchro;
        this.barrier = barrier;
        this.name = name;
    }

    @Override
    public void run() {
        if (needSynchro) {
            synchronized (array) {
                for (int i = 0; i < array.length; i++) {
                    array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        } else {
            for (int i = 0; i < array.length; i++) {
                array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        }

        try {
            this.barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }

    }
}
