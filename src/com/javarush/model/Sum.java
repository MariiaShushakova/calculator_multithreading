package com.javarush.model;

import com.javarush.View;

import java.util.List;
import java.util.concurrent.Callable;

public class Sum implements Callable<String> {

    private final List<Integer> numbers;

    public Sum(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public String call() throws Exception {
        int sum = 0;

        for (Integer num : numbers) {
            sum = sum + num;
        }
        return View.getSumString() + sum;
    }
}
