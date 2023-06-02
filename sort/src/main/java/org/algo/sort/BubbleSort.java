package org.algo.sort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BubbleSort extends Sort{
    @Override
    public int[] sort(int[] inputElements) {
        int n = inputElements.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (inputElements[j] > inputElements[j + 1]) {
                    int temp = inputElements[j];
                    inputElements[j] = inputElements[j + 1];
                    inputElements[j + 1] = temp;
                }
            }
        }
        return inputElements;
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
