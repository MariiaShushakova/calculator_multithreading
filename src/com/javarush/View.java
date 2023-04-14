package com.javarush;

import com.javarush.model.Operations;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class View {
    public static String getSumString() {
        return "Sum of all nums: ";
    }

    public static String getDiffString() {
        return "Diff of all nums: ";
    }

    public static String getMultString() {
        return "Mult of all nums: ";
    }

    public static String getFString(Map<Integer, Long> resultMap) {
        String resultStr = "Factorial: ";

        for (Map.Entry<Integer,Long> el : resultMap.entrySet()) {
            resultStr = resultStr +
                    "{num " + el.getKey() +
                    " | value" + el.getValue() + "}";
        }
        return resultStr;
    }

    public static void printTask(String result){
        System.out.println("Task result is: " + result);
    }

    private static Scanner scanner = new Scanner(System.in);

    public static int printConsoleAndReadCommand(){
        System.out.println("Select command: ");
        System.out.println("1 - add task");
        System.out.println("2 - run tasks");
        System.out.println("3 - exit");
        return scanner.nextInt();
    }

    public static Operations selectOperationType(){
        System.out.println("Select Operation Type: SUM, DIFF, MULT, FACTORIAL");
        return Operations.valueOf(scanner.next());
    }

    public static List<Integer> enterNums(){
        List<Integer> nums = new ArrayList<>();
        System.out.println("Enter number:");
        while(scanner.hasNextInt()){
            nums.add(scanner.nextInt());
        }
        scanner = new Scanner(System.in);
        return nums;
    }

    public static void printWrongCommand(){
        System.out.println("Wrong command");
    }
}
