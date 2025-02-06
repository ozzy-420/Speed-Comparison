package testers;

import algorithms.Algorithm;
import algorithms.CollectionsAlgorithm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


// The methods to override when extending this class:
// initializeData, initializeTests, runAlgorithms
public abstract class Tester<T> {
    protected boolean usesData = true;
    private Collection<T> tests;
    protected Map<String, Integer> winnersCount = new HashMap<>();
    protected Map<String, Double> timeCount = new HashMap<>();
    Tester() {
        tests = null;
    }
    Tester(int dataSize, int testsSize) {
        initializeData(dataSize);
        initializeTests(testsSize);
    }
    protected void updateCounters(Algorithm [] algorithms) {
        String winner = "null";
        double bestTime = Double.MAX_VALUE;
        for (Algorithm algorithm: algorithms) {
            double time = algorithm.getTime();
            String name = algorithm.getClass().getSimpleName();

            timeCount.put(name, timeCount.get(name) + time);

            if (time < bestTime) {
                bestTime = time;
                winner = name;
            }
        }
        winnersCount.put(winner, winnersCount.get(winner) + 1);
    }
    protected void initiateCounters(Algorithm[] algorithms) {
        if (algorithms == null) throw new IllegalArgumentException("Nie podano algorytmow");

        winnersCount = new HashMap<>();
        timeCount = new HashMap<>();

        for (Algorithm algorithm: algorithms) {
            winnersCount.put(algorithm.getClass().getSimpleName(), 0);
            timeCount.put(algorithm.getClass().getSimpleName(), 0.0);
        }
    }
    protected void printAlgorithmResult(Algorithm[] algorithms) {
        if (winnersCount == null || timeCount == null) throw new IllegalStateException("Nie zainicjalizowano licznikow");

        System.out.println("\n--- Podsumowanie ---");

        for (Algorithm algorithm: algorithms) {
            if (!winnersCount.containsKey(algorithm.getClass().getSimpleName())) throw new IllegalStateException("Nie zainicjalizowano licznika dla algorytmu");
            if (!timeCount.containsKey(algorithm.getClass().getSimpleName())) throw new IllegalStateException("Nie zainicjalizowano licznika dla algorytmu");

            System.out.println(algorithm.getClass().getSimpleName() + ": " + winnersCount.get(algorithm.getClass().getSimpleName()) + " zwycięstw, czas: " + timeCount.get(algorithm.getClass().getSimpleName()) + " ms");
        }
    }

    public void printAlgorithmResult(Algorithm algorithm) {
        System.out.println("Algorytm: " + algorithm.getClass().getSimpleName());
        System.out.println("Czas: " + algorithm.getTime());
        System.out.println();
    }
    public void runAlgorithms(Algorithm[] algorithms) {
        if (getTests() == null) throw new IllegalStateException("Nie zainicjalizowano danych");
        if (algorithms == null) throw new IllegalArgumentException("Nie podano algorytmow");

//        System.out.println("Liczba testow: " + getTests().size());
//        System.out.println("Wielkosc danych: " + getData().size());
//        System.out.println();

    }



    public Collection<T> getTests() {
        return tests;
    }
    public void setTests(Collection<T> tests) {
        this.tests = tests;
    }
    void initializeData(int elements) {
        if (elements < 0) throw new IllegalArgumentException("Liczba elementow musi byc dodatnia");
    }
    void initializeTests(int testers) {
        if (testers < 0) throw new IllegalArgumentException("Liczba testerow musi byc dodatnia");
    }
    public void compareAlgorithms(Algorithm[] algorithms, int max) {
        if (algorithms == null || algorithms.length < 1) throw new IllegalArgumentException("Nie podano algorytmów");
        if (max < 1) throw new IllegalArgumentException("Liczba elementów musi być wieksza niż 0");

        // Initializing counters
        initiateCounters(algorithms);

        //compareAlgorithms(algorithms, max);

        for (int i = 1; i < max; i++) {
            // Initializing data and tests
            if (usesData) initializeData(i);
            initializeTests(i);

            // Running the algorithms
            runAlgorithms(algorithms);

            // Updating counters
            updateCounters(algorithms);
        }

        // Podsumowanie ogólne
        printAlgorithmResult(algorithms);
    }
}
