package algorithms.graph_search;

import structures.Graph;

public class GraphSearchAlgorithm<T> extends algorithms.Algorithm {
    private Graph<T> graph;

    public Graph<T> getGraph() {
        return graph;
    }

    public void setGraph(Graph<T> graph) {
        this.graph = graph;
    }
}
