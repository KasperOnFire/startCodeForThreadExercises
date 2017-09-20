package day2.webscraper;

public class Tester {

    public static void main(String[] args) throws InterruptedException {
        long start = System.nanoTime();
        System.out.println("Avilable Processors: " + Runtime.getRuntime().availableProcessors());

        TagCounter tc1 = new TagCounter("http://www.fck.dk");
        tc1.start();
        TagCounter tc2 = new TagCounter("http://www.google.com");
        tc2.start();
        TagCounter tc3 = new TagCounter("http://politiken.dk/");
        tc3.start();

        tc1.join();
        tc2.join();
        tc3.join();

        long end = System.nanoTime();

        System.out.println("Time Parallel: " + (end - start));

        /*
    a) tc.run takes some time, since it has to connect and scrape the webpages for info.
    
    b) add extends Thread and @Override annotation to run method.
    
    c) difference is literally threading the methods. system.outs are empty since the threads havent finished scraping yet.
        Refactored by adding system.outs to the run method.

    d) 6 processors avaible. Time Sequential: 1410025934    
                               Time Parallel:  651242975
        Parallel is 2.1x as fast
         */
    }
}
