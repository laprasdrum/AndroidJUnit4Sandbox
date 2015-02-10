package com.laprasdrum.androidjunit4.random;

import java.util.List;

public class Randoms {
    public RandomNumberGenerator generator = new RandomNumberGeneratorImpl();

    public <T> T choice(List<T> options) {
        if (options.size() == 0) return null;
        int idx = generator.nextInt() % options.size();
        return options.get(idx);
    }
}
