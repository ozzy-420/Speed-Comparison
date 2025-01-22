package testers;

import algorithms.Algorithm;

import java.util.ArrayList;
import java.util.Collection;

public abstract class Tester<T> {
    private Collection<T> data;
    private Collection<T> tests;
    Tester() {
        data = null;
        tests = null;
    }
    Tester(int dataSize, int testsSize) {
        initializeTestsAndData(dataSize, testsSize);
    }
    public void runAlgorithms(Algorithm[] algorithms) {
        if (getData() == null || getTests() == null) throw new IllegalStateException("Nie zainicjalizowano danych");
        if (algorithms == null) throw new IllegalArgumentException("Nie podano algorytmow");

        System.out.println("Liczba testow: " + getTests().size());
        System.out.println("Wielkosc danych: " + getData().size());
        System.out.println();
    }
    public void initializeTestsAndData(int dataSize, int testsSize) {
        if (dataSize < 0 || testsSize < 0) throw new IllegalArgumentException("Liczba elementow i testerow musi byc dodatnia");
        //if (dataSize < testsSize) throw new IllegalArgumentException("Za malo elementow w porownaniu do testerow");

        initializeData(dataSize);
        initializeTests(testsSize);
    }

    public Collection<T> getData() {
        return data;
    }

    public void setData(Collection<T> data) {
        this.data = data;
    }

    public Collection<T> getTests() {
        return tests;
    }
    public void setTests(Collection<T> tests) {
        this.tests = tests;
    }
    void initializeData(int elements) {
        if (elements < 0) throw new IllegalArgumentException("Liczba elementow musi byc dodatnia");
    }
    void initializeTests(int testers) {
        if (testers < 0) throw new IllegalArgumentException("Liczba testerow musi byc dodatnia");
    }
}
