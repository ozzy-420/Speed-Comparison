package algorithms.graph_search;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class DFS<T> extends GraphSearchAlgorithm<T> {
    @Override
    protected void algorithm(T startNode, Set<T> visited, Deque<T> stack) {
        stack.push(startNode);

        while (!stack.isEmpty()) {
            T current = stack.pop();

            for (T neighbour : getGraph().getNeighbours(current)) {
                if (visited.add(neighbour)) {
                    stack.push(neighbour);
                }
            }
        }
    }
}

