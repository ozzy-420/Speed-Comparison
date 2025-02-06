package algorithms.string_iteration;

public class CharAt extends StringIterationAlgorithm {

    @Override
    protected void iterate(String string) {
        for (int i = 0; i < string.length(); i++) use(string.charAt(i));
    }
}
