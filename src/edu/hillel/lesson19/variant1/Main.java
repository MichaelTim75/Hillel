package edu.hillel.lesson19.variant1;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        log(new FileLogger());

        log(new StdOutLogger());

    }

    private static void log(Logger logger) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            logger.info("my text i=" + i);
            if (System.nanoTime() % 3 == 0) {
                logger.debug("my debug text i=" + i);
            }
            Thread.sleep(1);
        }
    }
}
