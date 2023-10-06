package edu.hillel.lesson17.realization2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class PetrolStation {
    private static final AtomicInteger amount = new AtomicInteger(1000);
    private static final int THREAD_POOL_SIZE = 3;
    private static final int MIN_DELAY = 3000;
    private static final int MAX_DELAY = 10000;
    private static final int MIN_REFILL_AMOUNT = 10;
    private static final int MAX_REFILL_AMOUNT = 50;

    private static final int MINIMAL_FUEL_AMOUNT = MAX_REFILL_AMOUNT * (THREAD_POOL_SIZE + 1);

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        for (int i = 0; i < THREAD_POOL_SIZE; i++) {
            int finalI = i;
            executorService.submit(() -> {
                while (getAmount() >= MINIMAL_FUEL_AMOUNT) {
                    final int delay = ThreadLocalRandom.current().nextInt(MIN_DELAY, MAX_DELAY + 1);
                    final int fuelAmount = ThreadLocalRandom.current().nextInt(MIN_REFILL_AMOUNT, MAX_REFILL_AMOUNT + 1);
                    System.out.println("Task " + finalI + " delay=" + delay + ", fuelAmount=" + fuelAmount + " start fuel to car");
                    try {
                        Thread.sleep(delay);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    doRefuel(fuelAmount);
                    System.out.println("Task delay=" + delay + ", fuelAmount=" + fuelAmount + " end fuel to car");
                    System.out.println("available=" + getAmount());
                }
            });
        }

        executorService.shutdown();
    }

    public static int getAmount() {
        return amount.get();
    }

    public static void doRefuel(int refillAmount) {
        amount.addAndGet(-1 * refillAmount);
    }

}
