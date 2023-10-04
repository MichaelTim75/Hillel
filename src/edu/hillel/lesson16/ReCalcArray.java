package edu.hillel.lesson16;

public class ReCalcArray implements Runnable{
    private final float[] array;
    private final boolean needSynchro;

    public ReCalcArray(float[] array, boolean needSynchro) {
        this.array = array;
        this.needSynchro = needSynchro;
    }

    @Override
    public void run() {
        if (needSynchro) {
            synchronized (array) {
                for (int i = 0; i < array.length; i++) {
                    array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        }
        else {
            for (int i = 0; i < array.length; i++) {
                array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        }
    }
}
