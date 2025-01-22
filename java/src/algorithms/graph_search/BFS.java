package algorithms.graph_search;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class BFS<T> extends GraphSearchAlgorithm<T> {
    public void run() {
        super.run();

        Set<T> unvisited = new HashSet<>(getGraph().getNodes());
        LinkedList<T> queue = new LinkedList<>();

        for (T node: getGraph().getNodes()) {
            if (unvisited.contains(node)) {
                bfs(node, unvisited, queue);
            }
        }
    }
    private void bfs(T node, Set<T> unvisited, LinkedList<T> queue) {
        unvisited.remove(node);
        for (T neighbour: getGraph().getNeighbours(node)) {
            if (unvisited.contains(neighbour)) {
                queue.addLast(neighbour);
            }
        }
        if (!queue.isEmpty()) bfs(queue.pop(), unvisited, queue);
    }
}
