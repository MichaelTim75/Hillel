package edu.hillel.lesson19.variant2;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Logger logger = new FileLogger();
        for (int i = 0; i < 10000; i++) {
            logger.info("my text i=" + i);
            if (System.nanoTime() % 3 == 0) {
                logger.debug("my debug text i=" + i);
            }
            Thread.sleep(1);
        }

        Logger logger2 = new StdOutLogger();
        for (int i = 0; i < 100; i++) {
            logger2.info("my text i=" + i);
            if (System.nanoTime() % 3 == 0) {
                logger2.debug("my debug text i=" + i);
            }
            Thread.sleep(1);
        }
    }
}
