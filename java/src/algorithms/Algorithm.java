package algorithms;

public abstract class Algorithm {
    private double startTime;
    public void updateStartTime() {
        startTime = System.nanoTime();
    }
    public double getTime() {
        return (System.nanoTime() - startTime) / 1_000_000_000.0;
    }

    public void run() {
        updateStartTime();
    }
}
