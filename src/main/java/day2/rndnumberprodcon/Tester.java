package day2.rndnumberprodcon;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Tester {

    public static void main(String[] args) throws InterruptedException {
        //This represent the Queue in the exercise-figure. Observe the size of the Queue
        ArrayBlockingQueue<Integer> numbers = new ArrayBlockingQueue(5);

        ExecutorService es = Executors.newCachedThreadPool();
        //Create and start four producers (P1-P4 in the exercise-figure)
        es.execute(new RandomNumberProducer(numbers));
        es.execute(new RandomNumberProducer(numbers));
        es.execute(new RandomNumberProducer(numbers));
        es.execute(new RandomNumberProducer(numbers));

        //Create and start single consumer (C1 in the exercise-figure)
        RandomNumberConsumer consumer = new RandomNumberConsumer(numbers);
        es.execute(consumer);

        es.shutdown();
        es.awaitTermination(10, TimeUnit.SECONDS);

        System.out.println("Total of all random numbers: " + consumer.getSumTotal());
        System.out.println("Number of random numbers below 50: " + consumer.getBelow50().size());
        System.out.println("Number of random numbers >= 50: " + consumer.getAboveOr50().size());

        /*
        a) if we have 4 threads we can theoretically get the numbers 4x as fast, or 4 numbers at a time.
        b) most modern processors have 2 or or 4 cores - those with only 2 usually supports 2 threads pr core.
        c) i would use offer() since this tries to add the number to the end of the queue, and returns true or false depending on the success of the action.
        d) i would use take() since tries to get an element, and if no are avaible, waits until it is and tries again.
         */
    }   
}
