package com.solution.DynamicProgramming;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ZeroOneMatrixTest {
    ZeroOneMatrix solution;

    @BeforeEach
    void init() {
        solution = new ZeroOneMatrix();
    }

    private void showArray(int[][] arr) {
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                System.out.print(String.format("(%d, %d) %s", row, col, arr[row][col]));
            }
            System.out.println();
        }
        System.out.println(String.format("--"));
    }

    @ParameterizedTest
    @CsvSource(value = { "0>0", "0,1;1,1>0,1;1,2", "0,0,1;0,1,1;1,0,1>0,0,1;0,1,2;1,0,1",
            "0,1,0,1;1,0,1,0;0,1,0,1;1,0,1,0>0,1,0,1;1,0,1,0;0,1,0,1;1,0,1,0",
            "0,1,0,1;1,1,1,0;0,1,1,1;1,0,1,1>0,1,0,1;1,2,1,0;0,1,2,1;1,0,1,2" }, delimiter = '>')
    void parameterized_test(String input, String expected) {
        String[] inputParts = input.split(";");
        int col = inputParts[0].split(",").length;

        int[][] inputArray = new int[inputParts.length][col];
        for (int i = 0; i < inputArray.length; i++) {
            int[] currentInputArray = Arrays.stream(inputParts[i].split(","))
                    .mapToInt(Integer::valueOf).toArray();
            inputArray[i] = currentInputArray;
        }
        showArray(inputArray);

        String[] expectedParts = expected.split(";");
        int[][] expectedArray = new int[inputParts.length][col];
        for (int i = 0; i < expectedArray.length; i++) {
            int[] currentExpectedArray = Arrays.stream(expectedParts[i].split(",")).mapToInt(Integer::valueOf)
                    .toArray();
            expectedArray[i] = currentExpectedArray;
        }
        showArray(expectedArray);

        int[][] actual = solution.updateMatrix(inputArray);
        assertArrayEquals(expectedArray, actual);
    }
}
