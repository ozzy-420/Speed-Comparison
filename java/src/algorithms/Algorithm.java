package algorithms;

public abstract class Algorithm {
    private double time;
    private double startTime;
    public void updateStartTime() {
        startTime = System.nanoTime();
    }
    public double getCurrentTime() {
        return (System.nanoTime() - startTime) / 1_000_000_000.0;
    }

    public void run() {
        updateStartTime();
    }
    public void saveTime() {
        time = getCurrentTime();
    }
    public double getTime() {
        return time;
    }
}
