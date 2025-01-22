package algorithms.contains;

import algorithms.CollectionsAlgorithm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListContainsAlgorithm<T> extends CollectionsAlgorithm<T> {
    @Override
    public void run() {
        super.run();

        for (T test: getTests()) {
            ((List<T>) getArguments()).contains(test);
        }
    }

    @Override
    protected void adjustArguments() {
        setArguments(new ArrayList<>(getArguments()));
    }
}
