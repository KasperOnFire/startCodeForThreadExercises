package day1.exc2;

import static java.lang.Thread.sleep;

public class BreakEven {

    public static void main(String[] args) throws InterruptedException {
        Even e = new Even();

        Thread t1 = new Thread(() -> {
            while (e.isGoing()) {
                e.next();
                if (e.getN() % 2 != 0) {
                    System.out.println("t1: UNEVEN" + e.getN());
                }
            }
        });
        Thread t2 = new Thread(() -> {
            while (e.isGoing()) {
                e.next();
                if (e.getN() % 2 != 0) {
                    System.out.println("t2: UNEVEN" + e.getN());
                }
            }
        });

        t1.start();
        t2.start();
        sleep(2000);
        e.setGoing(false);
        
        /*
        a) yes, but it takes more than just one execution of e.next()
        b) it can happen quite often, but when it happens an even number of times, it resets -goes back to even number.
        c) add synchronized to next();
        d) ?? synchronized fixes to problem, but takes 7 instructions per method call (2x3 in increment, and one return), therefore taking up some resources.
        */

    }

}
