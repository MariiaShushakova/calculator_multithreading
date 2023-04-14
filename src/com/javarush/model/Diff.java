package com.javarush.model;

import com.javarush.View;

import java.util.List;
import java.util.concurrent.Callable;

public class Diff implements Callable<String> {

    private final List<Integer> numbers;

    public Diff(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public String call() throws Exception {
        int diff = numbers.get(0);

        for (int i = 1; i < numbers.size(); i++) {
            diff = diff - numbers.get(i);
        }

        return View.getSumString() + diff;
    }
}
