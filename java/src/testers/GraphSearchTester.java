package testers;

import algorithms.Algorithm;
import algorithms.graph_search.GraphSearchAlgorithm;
import structures.Graph;

import java.util.ArrayList;
import java.util.Collections;

public class GraphSearchTester extends Tester<Integer> {
    // The methods to override when extending this class:
    // initializeData, initializeTests, runAlgorithms

    public Graph<Integer> getData() {
        return data;
    }

    public void setData(Graph<Integer> data) {
        this.data = data;
    }

    private Graph<Integer> data;
    public GraphSearchTester() {
        super();
    }
    public GraphSearchTester(int dataSize, int testsSize) {
        super(dataSize, testsSize);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void runAlgorithms(Algorithm[] algorithms) {
        for (Algorithm algorithm: algorithms) {
            if (algorithm instanceof algorithms.graph_search.GraphSearchAlgorithm) {
                ((GraphSearchAlgorithm<Integer>) algorithm).setGraph(getData());
                //((GraphSearchAlgorithm<Integer>) algorithm).setStart(getTests().iterator().next());
                algorithm.run();
                algorithm.saveTime();
            } else throw new IllegalArgumentException("Niepoprawny algorytm");
        }
    }

    @Override
    void initializeData(int elements) {
        super.initializeData(elements);

        setData(generators.Generator.generateIntegerGraph(elements));
    }

    @Override
    void initializeTests(int testers) {
        setTests(new ArrayList<>());
    }
}
