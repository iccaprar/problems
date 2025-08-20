package eu.yexperts.kids.alex.problems.problem1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static eu.yexperts.kids.alex.problems.tools.Helpers.readNumber;
import static eu.yexperts.kids.alex.problems.tools.Helpers.sumOfDigits;

/**
 * Problem 1: Read n numbers from the console and sort them ascending by the sum of their digits.
 */
public class Problem1 {

    public static void main(String[] args) throws IOException {
        System.out.println("Introduce how many numbers you want");
        int n = readNumber();
        System.out.println("You want to read " + n + " numbers");

        // read n numbers from the console and put them in a list
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            System.out.println("Introduce number " + i + ":");
            int number = readNumber();
            numbers.add(number);
        }
        // print the numbers
        System.out.println("You have introduced the following numbers:" + numbers);

        // sort the numbers by the sum of their digits
        boolean done = false;
        while (!done) {
            done = true;
            for (int i = 0; i < numbers.size() - 1; i++) {
                int sum1 = sumOfDigits(numbers.get(i));
                int sum2 = sumOfDigits(numbers.get(i + 1));
                if (sum1 > sum2) {
                    // swap the numbers
                    int temp = numbers.get(i);
                    numbers.set(i, numbers.get(i + 1));
                    numbers.set(i + 1, temp);
                    done = false;
                }
            }
        }

        // print the sorted numbers
        System.out.println("The numbers sorted by the sum of their digits are:" + numbers);
    }

}