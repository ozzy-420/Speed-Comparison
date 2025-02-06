import algorithms.Algorithm;
import algorithms.contains.BinaryContainsAlgorithm;
import algorithms.CollectionsAlgorithm;
import algorithms.contains.HashSetContainsAlgorithm;
import algorithms.contains.ListContainsAlgorithm;
import algorithms.graph_search.BFS;
import algorithms.graph_search.DFS;
import algorithms.string_iteration.*;
import algorithms.string_iteration.CharArrayForEach;
import testers.ContainsIntegerTester;
import testers.GraphSearchTester;
import testers.StringIterationTester;

public class Main {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        StringIterationTester tester = new StringIterationTester();
        tester.compareAlgorithms(new Algorithm[] {new CharArrayFor(), new CharArrayForEach(), new CharAt()}, 1000);


    }
}