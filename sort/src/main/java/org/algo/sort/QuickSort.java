package org.algo.sort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class QuickSort extends Sort{
    @Override
    public int[] sort(int[] inputElements) {
        quickSort(inputElements, 0, inputElements.length - 1);
        return inputElements;
    }

    public void quickSort(int[] inputElements, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(inputElements, low, high);
            quickSort(inputElements, low, pivotIndex - 1);
            quickSort(inputElements, pivotIndex + 1, high);
        }
    }

    public int partition(int[] inputElements, int low, int high) {
        int pivot = inputElements[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (inputElements[j] < pivot) {
                i++;
                swap(inputElements, i, j);
            }
        }

        swap(inputElements, i + 1, high);
        return i + 1;
    }

    public void swap(int[] inputElements, int i, int j) {
        int temp = inputElements[i];
        inputElements[i] = inputElements[j];
        inputElements[j] = temp;
    }


    @Override
    public void sort(String inputFile, String outputFile) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            String line = reader.readLine();
            reader.close();
            //sTRING To Integer array
            String[] elements = line.split(",");
            int[] inputElements = new int[elements.length];
            for (int i = 0; i < elements.length; i++) {
                inputElements[i] = Integer.parseInt(elements[i].trim());
            }

            int[] sortedElements = sort(inputElements);

            FileWriter writer = new FileWriter(outputFile);
            for (int i = 0; i < sortedElements.length; i++) {
                writer.write(String.valueOf(sortedElements[i]));
                if (i < sortedElements.length - 1) {
                    writer.write(",");
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
