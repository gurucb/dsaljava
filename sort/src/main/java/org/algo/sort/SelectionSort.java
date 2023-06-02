package org.algo.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class SelectionSort extends Sort {

    @Override
    public int[] sort(int[] inputElements) {
        int n = inputElements.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (inputElements[j] < inputElements[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = inputElements[minIndex];
            inputElements[minIndex] = inputElements[i];
            inputElements[i] = temp;
        }
        return inputElements;
    }

    @Override
    public void sort(String inputFile, String outputFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line = reader.readLine();
            if (line != null) {
                String[] numbers = line.split(",");
                int[] array = new int[numbers.length];
                for (int i = 0; i < numbers.length; i++) {
                    array[i] = Integer.parseInt(numbers[i]);
                }

                int[] sortedArray = sort(array);

                String sortedNumbers = Arrays.toString(sortedArray)
                        .replace("[", "")
                        .replace("]", "")
                        .replace(" ", "");

                writer.write(sortedNumbers);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
