package com.folatech.recursion.fibonaccinth;

public class FibonacciNth {

    /**
     * Difficulty level: easy
     */
    public static void main(String[] args) {

        int number = 5;
        int answer = fib(number);
        System.out.println("number: " + number + ", answer: " + answer);

        answer = fibWithRecursion(number);
        System.out.println("number: " + number + ", answer: " + answer);
    }

    static int fib(int num) {
        int indexNumber = 0;

        if (num == 1) {
            return 0;
        } else if (num == 2) {
            return 1;
        }

        int number1 = 0;
        int number2 = 1;

        System.out.println("number1: " + number1);
        System.out.println("number2: " + number2);

        int sum = 0;
        for (int i = 2; i < num; i++) {
            sum = number1 + number2;
            System.out.println("number" + i + ": " + sum);
            number1 = number2;
            number2 = sum;
            indexNumber = sum;
        }
        return indexNumber;
    }

    static int fibWithRecursion(int num) {
        if (num <= 1) {
            return num;
        }
        int number1 = fibWithRecursion(num - 1);
        int number2 = fibWithRecursion(num - 2);
        return number1 + number2;
    }
}
