package eu.yexperts.kids.alex.problems.problem2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static eu.yexperts.kids.alex.problems.tools.Helpers.readNumber;

/**
 * Problem2: given a list of digits, sorted in descending order, check if it is possible to form a palindrome from them
 * and if so, print it. If not, print "imposibil".
 * Example input: 8 7 7 4 4 produces output: 74847
 * Example input: 8 8 7 5 5 4 4 0 produces output: imposibil
 */
public class Problem2 {

    public static void main(String[] args) throws IOException {

        System.out.println("Introduce how many numbers you want");
        int n = readNumber();
        System.out.println("You want to read " + n + " numbers");

        // read n numbers from the console and put them in a list
        List<Integer> inputList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            System.out.println("Introduce number " + i + ":");
            int number = readNumber();
            inputList.add(number);
        }
        // print the numbers
        System.out.println("You have introduced the following numbers:" + inputList);

        // solve the problem
        Problem2 problem = new Problem2();
        var result = problem.solve(inputList);

        if (result.impossible()) {
            // if we cannot form a palindrome, we print "imposibil"
            System.out.println("imposibil");
        } else {
            // if we can form a palindrome, we print it
            System.out.println("posibil");
            System.out.println(result.palindrome());
        }
    }

    Result solve(List<Integer> inputList) {

        // sort the numbers in descending order

        inputList.sort((a, b) -> b - a);
        System.out.println("The numbers sorted in descending order are: " + inputList);

        // check if it is possible to form a palindrome

        int len = inputList.size();

        List<Integer> listFinal = new ArrayList<>();
        // initialize the final list with zeros
        for (int i = 0; i < len; i++) {
            listFinal.add(0);
        }

        int poslist = 0;
        int singlenum = -1;
        int posappendleft = 0;
        int posappendright = len - 1;
        boolean impossible = false;

        while (poslist < len && !impossible) {
            int x = inputList.get(poslist);
            int y = -1;
            if (poslist + 1 < len) {
                y = inputList.get(poslist + 1);
            }
            if (x == y) {
                // put the two numbers in the palindrome
                listFinal.set(posappendleft, x);
                listFinal.set(posappendright, y);
                posappendleft++;
                posappendright--;
                poslist = poslist + 2;
            } else {
                if (singlenum == -1) {
                    // if we don't have a single number yet, we can take this one
                    singlenum = x;
                    // then look for the next pair
                    poslist = poslist + 1;
                } else {
                    // if we already have a single number, we cannot form a palindrome
                    impossible = true;
                }
            }
        }

        if (singlenum != -1) {
            // if we have a single number, we can append it in the middle
            listFinal.set(posappendleft, singlenum);
        }

        return new Result(impossible, listFinal);
    }

    record Result(boolean impossible, List<Integer> palindrome) {

    }

}
