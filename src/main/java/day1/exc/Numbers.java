package day1.exc;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kasper
 */
public class Numbers {

    public static void main(String[] args) throws InterruptedException {

        final Running running = new Running();

        Thread t1 = new Thread(() -> {
            long total = 0;
            for (long i = 0; i < 1000000000; i++) {
                total += i;
            }
            System.out.println(total);
        });

        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("t2: " + i);
                try {
                    sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Numbers.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        Thread t3 = new Thread(() -> {
            int i = 10;
            while (running.isRunner()) {
                System.out.println("t3:" + i);
                i++;
                try {
                    sleep(3000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Numbers.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();

        sleep(10000);
        running.setRunner(false);

        /*
        a) the program works, because of the sleeping. so by accident.
        b) we need to synchronize the boolean value, so we set it to volatile.
        c) 
        
        
         */
    }

}
