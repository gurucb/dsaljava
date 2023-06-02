package org.algo.sort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MergeSort extends Sort {

    @Override
    public int[] sort(int[] inputElements) {
        int n = inputElements.length;
        int[] tempArray = new int[n];
        mergeSort(inputElements, tempArray, 0, n - 1);
        return inputElements;
    }

    public void mergeSort(int[] inputElements, int[] tempArray, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(inputElements, tempArray, left, mid);
            mergeSort(inputElements, tempArray, mid + 1, right);
            merge(inputElements, tempArray, left, mid, right);
        }
    }

    public void merge(int[] inputElements, int[] tempArray, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            tempArray[i] = inputElements[i];
        }

        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (tempArray[i] <= tempArray[j]) {
                inputElements[k] = tempArray[i];
                i++;
            } else {
                inputElements[k] = tempArray[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            inputElements[k] = tempArray[i];
            i++;
            k++;
        }
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
