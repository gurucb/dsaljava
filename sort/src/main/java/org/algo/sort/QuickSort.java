package org.algo.sort;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class QuickSort extends Sort {

    @Override
    public int[] sort(int[] inputElements) {
        quickSort(inputElements, 0, inputElements.length - 1);
        return inputElements;
    }

    private void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(array, low, high);
            quickSort(array, low, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, high);
        }
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, high);
        return i + 1;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
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

