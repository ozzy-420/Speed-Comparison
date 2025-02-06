package algorithms.string_iteration;

public class CharArrayFor extends StringIterationAlgorithm {
    @Override
    protected void iterate(String string) {
        char [] chars = string.toCharArray();
        for (int i = 0; i < chars.length; i++) use(chars[i]);
    }
}
