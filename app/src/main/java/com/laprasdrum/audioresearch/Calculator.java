package com.laprasdrum.audioresearch;

public class Calculator {

    public Calculator() {
    }

    public int add(int x, int y) {
        return x + y;
    }

    public float add(float x, float y) {
        return x + y;
    }

    public float divide(float x, float y) {
        if (y == 0) throw new IllegalArgumentException("divide by zero.");
        return (float)x / (float)y;
    }
}
