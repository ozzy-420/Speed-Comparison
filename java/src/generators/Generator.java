package generators;

import structures.Graph;

import java.util.*;

public class Generator {
    public static final Random generator = new Random();
    public static Graph<Integer> generateIntegerGraph(int size) {
        Map<Integer, Collection<Integer>> map = new HashMap<>();
        List<Set<Integer>> listOfNeighbours = new ArrayList<>();

        while (map.keySet().size() < size) {
            Set<Integer> neighbours = new HashSet<>();
            listOfNeighbours.add(neighbours);
            map.put(generator.nextInt(), neighbours);
        }

        List<Integer> keys = new ArrayList<>(map.keySet());
        for (Set<Integer> neighbours: listOfNeighbours) {
            for (int i = 0; i < generator.nextInt(size); i++) {
                neighbours.add(keys.get(generator.nextInt(keys.size())));
            }
        }

        return new Graph<>(map);
    }
}
