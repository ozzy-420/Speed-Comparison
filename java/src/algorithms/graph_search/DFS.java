package algorithms.graph_search;

import java.util.HashSet;
import java.util.Set;

public class DFS<T> extends GraphSearchAlgorithm<T> {
    public void run() {
        super.run();

        Set<T> unvisited = new HashSet<>(getGraph().getNodes());

        for (T node: getGraph().getNodes()) {
            if (unvisited.contains(node)) {
                dfs(node, unvisited);
            }
        }
    }
    private void dfs(T node, Set<T> unvisited) {
        unvisited.remove(node);
        for (T neighbour: getGraph().getNeighbours(node)) {
            if (unvisited.contains(neighbour)) dfs(neighbour, unvisited);
        }
    }
}
