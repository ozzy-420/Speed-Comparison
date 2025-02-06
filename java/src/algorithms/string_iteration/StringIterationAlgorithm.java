package algorithms.string_iteration;

import algorithms.Algorithm;

public abstract class StringIterationAlgorithm extends Algorithm {
    private String string;
    @Override
    public void run() {
        super.run();
        iterate(string);
    }
    protected abstract void iterate(String string);
    protected void use(char c) {

    }
    public void setString(String string) {
        this.string = string;
    }
}
