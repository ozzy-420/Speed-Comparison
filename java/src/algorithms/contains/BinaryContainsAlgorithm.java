package algorithms.contains;

import algorithms.CollectionsAlgorithm;

import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class BinaryContainsAlgorithm<T extends Comparable<T>> extends CollectionsAlgorithm<T> {
    @Override
    public void run() {
        super.run();

        for (T test: getTests()) {
            Collections.binarySearch((List<T>) getArguments(), test);
        }

        //time = getTime();
    }

    @Override
    protected void adjustArguments() {
        List<T> data = new ArrayList<>(getArguments());
        Collections.sort(data);
        setArguments(data);
    }
}
