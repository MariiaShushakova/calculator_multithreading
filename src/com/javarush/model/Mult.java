package com.javarush.model;

import com.javarush.View;

import java.util.List;
import java.util.concurrent.Callable;

public class Mult implements Callable<String> {

    private final List<Integer> numbers;

    public Mult(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public String call() throws Exception {
        int result = 1;
        for (int num:numbers) {
            result = result * num;
        }
        return View.getMultString() + result;
    }
}
