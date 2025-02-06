package algorithms.graph_search;

import structures.Graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class BFS<T> extends GraphSearchAlgorithm<T> {
    protected void algorithm(T node, Set<T> visited, Deque<T> queue) {
        queue.addLast(node);

        while (!queue.isEmpty()) {
            T current = queue.removeFirst();
            for (T neighbour : getGraph().getNeighbours(current)) {
                if (visited.add(neighbour)) {
                    queue.addLast(neighbour);
                }
            }
        }
    }
}
