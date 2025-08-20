package eu.yexperts.kids.alex.problems.problem2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Problem2Test {

    Problem2 problem = new Problem2();

    @Test
    void testSolveWithPalindromeInput() {
        // given
        List<Integer> input = Arrays.asList(7, 4, 7, 4, 8);

        // when
        var result = problem.solve(input);

        // then
        assertFalse(result.impossible());
        var expectedPalindrome = List.of(7, 4, 8, 4, 7);
        assertEquals(expectedPalindrome, result.palindrome());
    }

    @Test
    void testSolveWithImpossibleInput() {
        // given
        List<Integer> input = Arrays.asList(8, 7, 4, 5, 5, 4, 8, 0);

        // when
        var result = problem.solve(input);

        // then
        assertTrue(result.impossible());
    }

    @Test
    void testSolveWithImpossibleInput2() {
        // given
        List<Integer> input = Arrays.asList(8, 7, 8, 4, 5, 0, 4, 5);

        // when
        var result = problem.solve(input);

        // then
        assertTrue(result.impossible());
    }



}