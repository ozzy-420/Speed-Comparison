package testers;

import algorithms.Algorithm;

import java.util.ArrayList;
import java.util.List;

public class StringIterationTester extends Tester<String> {
    @Override
    public void runAlgorithms(Algorithm[] algorithms) {
        super.runAlgorithms(algorithms);

//        System.out.println("Liczba testow: " + getTests().size());
//        System.out.println("Wielkosc danych: " + getData().size());
//        System.out.println();

        for (Algorithm algorithm: algorithms) {
            if (algorithm instanceof algorithms.string_iteration.StringIterationAlgorithm) {

                ((algorithms.string_iteration.StringIterationAlgorithm) algorithm).setString(getTests().iterator().next());

                algorithm.run();
                algorithm.saveTime();
            } else throw new IllegalArgumentException("Niepoprawny algorytm");
        }
    }
    void initializeData(int elements) {
        super.initializeData(elements);
        usesData = false;
    }
    void initializeTests(int testers) {
        super.initializeTests(testers);

        List<String> tests = new ArrayList<>();
        for (int i = 0; i < testers; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < testers; j++) {
                builder.append((char) (Math.random() * 26 + 'a'));
            }
            tests.add(builder.toString());
        }

        setTests(tests);
    }
}
