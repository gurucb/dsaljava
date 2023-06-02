package org.algo.sort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class InsertionSort extends Sort{

    @Override
    public int[] sort(int[] inputElements) {
        int n = inputElements.length;

        for (int i = 1; i < n; i++) {
            int key = inputElements[i];
            int j = i - 1;

            while (j >= 0 && inputElements[j] > key) {
                inputElements[j + 1] = inputElements[j];
                j = j - 1;
            }
            inputElements[j + 1] = key;
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

