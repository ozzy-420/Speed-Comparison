package algorithms.graph_search;

import structures.Graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public abstract class GraphSearchAlgorithm<T> extends algorithms.Algorithm {
    private Graph<T> graph;

    public Graph<T> getGraph() {
        return graph;
    }
    protected abstract void algorithm(T startNode, Set<T> visited, Deque<T> deque);

    public void setGraph(Graph<T> graph) {
        this.graph = graph;
    }
    @Override
    public void run() {
        super.run();

        ArrayDeque<T> dequeue = new ArrayDeque<>();
        Set<T> visited = new HashSet<>();

        for (T node : getGraph().getNodes()) {
            if (visited.add(node)) {
                algorithm(node, visited, dequeue);
            }
        }
    }
}
