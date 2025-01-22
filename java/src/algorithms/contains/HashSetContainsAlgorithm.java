package algorithms.contains;

import algorithms.CollectionsAlgorithm;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class HashSetContainsAlgorithm<T> extends CollectionsAlgorithm<T> {

    @Override
    public void run() {
        super.run();

        for (T test: getTests()) {
            ((HashSet<T>) getArguments()).contains(test);
        }
    }

    @Override
    protected void adjustArguments() {
        setArguments(new HashSet<>(getArguments()));
    }
}
