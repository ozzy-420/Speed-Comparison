package testers;

import algorithms.Algorithm;
import algorithms.CollectionsAlgorithm;

import java.util.*;

public class ContainsIntegerTester extends Tester<Integer> {
    private Collection<Integer> data;

    public Collection<Integer> getData() {
        return data;
    }

    public void setData(Collection<Integer> data) {
        this.data = data;
    }

    public ContainsIntegerTester() {
        super();
    }
    public ContainsIntegerTester(int dataSize, int testsSize) {
        super(dataSize, testsSize);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void runAlgorithms(Algorithm[] algorithms) {
        super.runAlgorithms(algorithms);

        for (Algorithm algorithm: algorithms) {

            if (algorithm instanceof CollectionsAlgorithm) {
                ((CollectionsAlgorithm<Integer>) algorithm).setTests(getTests());
                ((CollectionsAlgorithm<Integer>) algorithm).setArguments(getData());
                algorithm.run();
                algorithm.saveTime();
            } else throw new IllegalArgumentException("Niepoprawny algorytm");

            //printAlgorithmResult(algorithm);
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
