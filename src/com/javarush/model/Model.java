package com.javarush.model;

import com.javarush.View;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class Model {
    private final List<FutureTask<String>> tasks = new ArrayList();
    private ExecutorService executorService = Executors.newCachedThreadPool();

    public void addTask(Operations operation, List<Integer> numbers){
        switch (operation){
            case SUM -> {
                tasks.add(new FutureTask<String>(new Sum(numbers)));
            }
            case DIFF -> {
                tasks.add(new FutureTask<String>(new Diff(numbers)));
            }
            case MULT -> {
                tasks.add(new FutureTask<String>(new Mult(numbers)));
            }
            case FACTORIAL -> {
                tasks.add(new FutureTask<String>(new Factorial(new HashSet<>(numbers))));
            }
            default -> {
                System.out.println("Wrong operation");
            }
        }
    }

    public void execute(){
        for (FutureTask<String> task:tasks) {
            executorService.submit(task);
        }
        try {
            check(tasks);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void check(List<FutureTask<String>> tasks) throws ExecutionException, InterruptedException {
        boolean allTasksDone = false;

        while (!allTasksDone){
            allTasksDone = true;
            for (FutureTask<String> task : tasks) {
                if(!task.isDone())  allTasksDone = false;

            }
        }

        for (FutureTask<String> task:tasks) {
            View.printTask(task.get());
        }
    }
}
