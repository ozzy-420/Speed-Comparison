import algorithms.contains.BinaryContainsAlgorithm;
import algorithms.CollectionsAlgorithm;
import algorithms.contains.HashSetContainsAlgorithm;
import algorithms.contains.ListContainsAlgorithm;
import testers.ContainsIntegerTester;

public class Main {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ContainsIntegerTester tester = new ContainsIntegerTester();
        tester.compareAlgorithms(new CollectionsAlgorithm[] {new ListContainsAlgorithm<Integer>(), new HashSetContainsAlgorithm<Integer>(), new BinaryContainsAlgorithm<Integer>()}, 100);


    }
}