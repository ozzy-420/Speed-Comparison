package testers;

import algorithms.CollectionsAlgorithm;

import java.util.*;

public class ContainsIntegerTester extends Tester<Integer> {

    public ContainsIntegerTester() {
        super();
    }
    public ContainsIntegerTester(int dataSize, int testsSize) {
        super(dataSize, testsSize);
    }

    public void runAlgorithms(CollectionsAlgorithm<Integer>[] algorithms) {
        super.runAlgorithms(algorithms);

        for (CollectionsAlgorithm<Integer> algorithm: algorithms) {
            algorithm.setTests(getTests());
            algorithm.setArguments(getData());

            algorithm.run();
            double time = algorithm.getTime();

            System.out.println("Algorytm: " + algorithm.getClass().getSimpleName());
            System.out.println("Czas: " + time);
            System.out.println();
        }
    }
    public void compareAlgorithms(CollectionsAlgorithm<Integer>[] algorithms, int max) {
        if (max < 1) throw new IllegalArgumentException("Liczba elementów musi być wieksza niż 0");

        // Licznik zwycięstw dla każdego algorytmu
        Map<String, Integer> winnersCount = new HashMap<>();

        for (int i = 1; i < max; i++) {
            System.out.println("\n--- Porównanie dla zestawu danych o rozmiarze: " + i + " ---");
            initializeTestsAndData(i, i);

            Map<Double, CollectionsAlgorithm<Integer>> results = new HashMap<>();

            for (CollectionsAlgorithm<Integer> algorithm : algorithms) {
                algorithm.setTests(getTests());
                algorithm.setArguments(getData());

                algorithm.run();
                results.put(algorithm.getTime(), algorithm);
            }

            if (results.keySet().size() == 1) {
                System.out.println("Wszystkie algorytmy mają taki sam czas: " + results.keySet().iterator().next() + " ms");
            } else {
                double minTime = Collections.min(results.keySet());
                double maxTime = Collections.max(results.keySet());

                // Wyświetlenie wyników dla każdego algorytmu
                System.out.println("Wyniki dla każdego algorytmu:");
                results.forEach((time, algorithm) ->
                        System.out.println(algorithm.getClass().getSimpleName() + ": " + time + " ms"));

                // Informacja o najszybszym algorytmie
                CollectionsAlgorithm<Integer> fastestAlgorithm = results.get(minTime);
                System.out.println("Najszybszy algorytm: " + fastestAlgorithm.getClass().getSimpleName() + " czas: " + minTime + " ms");

                // Aktualizacja licznika zwycięstw
                String fastestName = fastestAlgorithm.getClass().getSimpleName();
                winnersCount.put(fastestName, winnersCount.getOrDefault(fastestName, 0) + 1);
            }
        }

        // Podsumowanie ogólne
        System.out.println("\n--- Podsumowanie ---");
        if (winnersCount.isEmpty()) {
            System.out.println("Brak zwycięzców (algorytmy miały takie same czasy).");
        } else {
            System.out.println("Zwycięstwa algorytmów:");
            winnersCount.forEach((algorithm, count) ->
                    System.out.println(algorithm + ": " + count + " zwycięstw"));
        }
    }

    // Helping methods
    @Override
    void initializeData(int elements) {
        super.initializeData(elements);

        setData(new ArrayList<>(elements));

        Random generator = new Random();
        int random = generator.nextInt();

        for (int i = 0; i < elements; i++) {
            while (getData().contains(random)) {
                random = generator.nextInt();
            }
            getData().add(random);
        }
    }
    @Override
    void initializeTests(int testers) {
        super.initializeTests(testers);

        Random generator = new Random();
        int random = generator.nextInt();
        setTests(new ArrayList<>(testers));

        for (int i = 0; i < testers; i++) {
            while (getTests().contains(random)) {
                random = generator.nextInt();
            }
            getTests().add(random);
        }
    }
}
