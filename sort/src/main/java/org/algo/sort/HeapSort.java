package org.algo.sort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class HeapSort extends Sort{
    @Override
    public int[] sort(int[] inputElements) {
        int n = inputElements.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(inputElements, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = inputElements[0];
            inputElements[0] = inputElements[i];
            inputElements[i] = temp;
            heapify(inputElements, i, 0);
        }
        return inputElements;
    }

    public void heapify(int[] inputElements, int heapSize, int rootIndex) {
        int largest = rootIndex;
        int leftChild = 2 * rootIndex + 1;
        int rightChild = 2 * rootIndex + 2;


        if (leftChild < heapSize && inputElements[leftChild] > inputElements[largest]) {
            largest = leftChild;
        }

        if (rightChild < heapSize && inputElements[rightChild] > inputElements[largest]) {
            largest = rightChild;
        }
        if (largest != rootIndex) {
            int temp = inputElements[rootIndex];
            inputElements[rootIndex] = inputElements[largest];
            inputElements[largest] = temp;

            heapify(inputElements, heapSize, largest);
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
