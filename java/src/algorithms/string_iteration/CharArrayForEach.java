package algorithms.string_iteration;

public class CharArrayForEach extends StringIterationAlgorithm {
    @Override
    protected void iterate(String string) {
        for (char c: string.toCharArray()) use(c);
    }
}
