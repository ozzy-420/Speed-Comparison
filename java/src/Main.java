import algorithms.Algorithm;
import algorithms.contains.BinaryContainsAlgorithm;
import algorithms.CollectionsAlgorithm;
import algorithms.contains.HashSetContainsAlgorithm;
import algorithms.contains.ListContainsAlgorithm;
import algorithms.graph_search.BFS;
import algorithms.graph_search.DFS;
import testers.ContainsIntegerTester;
import testers.GraphSearchTester;

public class Main {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        GraphSearchTester tester = new GraphSearchTester();
        tester.compareAlgorithms(new Algorithm[] {new DFS<Integer>()}, 1000);


    }
}