package org.algo.sort;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class MergeSort extends Sort {

    @Override
    public int[] sort(int[] inputElements) {
        if (inputElements.length <= 1) {
            return inputElements;
        }

        int mid = inputElements.length / 2;
        int[] leftArray = Arrays.copyOfRange(inputElements, 0, mid);
        int[] rightArray = Arrays.copyOfRange(inputElements, mid, inputElements.length);

        leftArray = sort(leftArray);
        rightArray = sort(rightArray);

        return merge(leftArray, rightArray);
    }

    private int[] merge(int[] leftArray, int[] rightArray) {
        int leftLength = leftArray.length;
        int rightLength = rightArray.length;
        int[] mergedArray = new int[leftLength + rightLength];
        int i = 0, j = 0, k = 0;

        while (i < leftLength && j < rightLength) {
            if (leftArray[i] <= rightArray[j]) {
                mergedArray[k] = leftArray[i];
                i++;
            } else {
                mergedArray[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < leftLength) {
            mergedArray[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightLength) {
            mergedArray[k] = rightArray[j];
            j++;
            k++;
        }

        return mergedArray;
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

