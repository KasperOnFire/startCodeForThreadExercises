package day1.exc2;

public class Even {

    private int n = 0;
    private boolean going = true;

    public synchronized int next() {
        n++;
        n++;
        return n;
    }

    public int getN() {
        return n;
    }

    public boolean isGoing() {
        return going;
    }

    public void setGoing(boolean going) {
        this.going = going;
    }

}
