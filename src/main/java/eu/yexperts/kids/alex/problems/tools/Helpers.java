package eu.yexperts.kids.alex.problems.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Helpers {

    /**
     * Calculates the sum of the digits of a number.
     *
     * @param number the number whose digits will be summed
     * @return the sum of the digits of the number
     */
    public static int sumOfDigits(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    /**
     * Reads a number from the console.
     *
     * @return the number read from the console
     * @throws IOException if an I/O error occurs
     */
    public static int readNumber() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        String input = reader.readLine();
        // Convert the input to an integer
        return Integer.parseInt(input);
    }
}
