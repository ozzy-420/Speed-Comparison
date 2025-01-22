package algorithms;
import java.util.Collection;

public abstract class CollectionsAlgorithm<T> extends Algorithm {
    private Collection<T> tests;
    private Collection<T> arguments;
    @Override
    public void run() {
        adjustArguments();
//        if (getArguments() == null || getArguments().isEmpty()) {
//            return;
//        }
        super.run();
    }

    protected abstract void adjustArguments();

    public Collection<T> getTests() {
        return tests;
    }

    public void setTests(Collection<T> tests) {
        this.tests = tests;
    }

    public Collection<T> getArguments() {
        return arguments;
    }

    public void setArguments(Collection<T> arguments) {
        this.arguments = arguments;
    }

}
