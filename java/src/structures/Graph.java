package structures;

import java.util.*;


public class Graph<T> {

    private final Map<T, Collection<T>> nodesToNeighbours;
    public Graph(Map<T, Collection<T>> map) {
        this.nodesToNeighbours = new HashMap<>();

        for (T key: map.keySet()) {
            Collection<T> neighbours = map.get(key);
            if (neighbours == null) neighbours = new ArrayList<>();

            this.nodesToNeighbours.put(key, neighbours);

            for (T value: map.get(key)) {
                if (!nodesToNeighbours.containsKey(value)) {
                    nodesToNeighbours.put(value, new ArrayList<>());
                }
            }
        }
    }
    public Collection<T> getNodes() {
        return nodesToNeighbours.keySet();
    }

    public boolean isNeighbourOf(T value1, T value2) {
        // Sprawdzamy czy wartosci sa w grafie
        if (!nodesToNeighbours.containsKey(value1)) throw new IllegalArgumentException("Value " + value1 + " not in graph");
        if (!nodesToNeighbours.containsKey(value2)) throw new IllegalArgumentException("Value " + value2 + " not in graph");

        return nodesToNeighbours.get(value1).contains(value2);
    }

    public Collection<T> getNeighbours(T value) {
        // Sprawdzamy czy wezel istnieje w grafie
        if (!nodesToNeighbours.containsKey(value)) throw new IllegalArgumentException("Value " + value + " not in graph");

        // Zwracamy wynik
        return nodesToNeighbours.get(value);
    }
    public void addNode(T value, Collection<T> neighbours) {
        if (neighbours == null) neighbours = new ArrayList<>();
        nodesToNeighbours.put(value, neighbours);
    }
}
