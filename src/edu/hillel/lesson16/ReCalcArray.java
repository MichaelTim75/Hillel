package edu.hillel.lesson16;

public class ReCalcArray implements Runnable{
    private final float[] array;

    public ReCalcArray(float[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        synchronized (array) {
            for (int i = 0; i < array.length; i++) {
                array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        }
    }
}
