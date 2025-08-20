package eu.yexperts.kids.alex.problems.problem1;

import org.apache.commons.lang3.tuple.Pair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static eu.yexperts.kids.alex.problems.tools.Helpers.readNumber;
import static eu.yexperts.kids.alex.problems.tools.Helpers.sumOfDigits;

/**
 * Problem 1 v2: Read n numbers from the console and sort them ascending by the sum of their digits.
 * Use a more efficient data structure for sorting, to avoid the calculation of the sum of digits for each comparison.
 * For example, use a list of pairs (position in the original list, sum of digits) and sort by the second element.
 */
public class Problem1v2 {

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

        // create a list of pairs (position in original list, sum of digits)
        List<Pair<Integer, Integer>> pairs = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            int sum = sumOfDigits(numbers.get(i));
            pairs.add(Pair.of(i, sum));
        }

        // sort the pairs by the sum of digits, using a simple sort
        boolean done = false;
        while (!done) {
            done = true;
            for (int i = 0; i < pairs.size() - 1; i++) {
                if (pairs.get(i).getRight() > pairs.get(i + 1).getRight()) {
                    // swap the pairs
                    Pair<Integer, Integer> temp = pairs.get(i);
                    pairs.set(i, pairs.get(i + 1));
                    pairs.set(i + 1, temp);
                    done = false;
                }
            }
        }

        // print the sorted numbers
        System.out.println("The numbers sorted by the sum of their digits are:");
        for (Pair<Integer, Integer> pair : pairs) {
            System.out.println("Number: " + numbers.get(pair.getLeft()) + ", Sum of digits: " + pair.getRight());
        }
        System.out.println("The sorted numbers are:");
        for (Pair<Integer, Integer> pair : pairs) {
            System.out.print(numbers.get(pair.getLeft()) + " ");
        }

    }

}
