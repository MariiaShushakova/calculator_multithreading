package com.javarush.model;

import com.javarush.View;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;

public class Factorial implements Callable<String> {

    private final Set<Integer> numbers;

    public Factorial(Set<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public String call() throws Exception {
        Map<Integer, Long> mapResult = new HashMap<>();

        for(Integer num : numbers){
            Long result = 1L;
            for (int i = 1; i <= num; i++) {
                result = result * i;
            }
            mapResult.put(num, result);
        }
        return View.getFString(mapResult);
    }
}
