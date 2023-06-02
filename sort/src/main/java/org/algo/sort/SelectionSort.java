package org.algo.sort;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort extends Sort{
    @Override
    public int[] sort(int[] inputElements) {
        int n = inputElements.length;
        for(int i=0;i<n;i++){
            int min_index = i;
            for(int j=i+1;j<n;j++){
                if(inputElements[j]<inputElements[min_index]){
                    min_index = j;
                }
            }
            int temp = inputElements[i];
            inputElements[i] = inputElements[min_index];
            inputElements[min_index] = temp;
        }

        return inputElements;
    }

    @Override
    public void sort(String inputFile, String outputFile) {
        try {
            long startTime = System.nanoTime();
            BufferedReader reader=new BufferedReader(new FileReader(inputFile));
            String line=reader.readLine();
            reader.close();

            String [] element=line.split(",");
            int [] inputElement=new int[element.length];

            for(int i=0;i<=element.length-1;i++){
                inputElement[i]=Integer.parseInt(element[i].trim());
            }

            int [] sortElement=sort(inputElement);

            FileWriter writer=new FileWriter(outputFile);
            for(int i=0;i<sortElement.length;i++){
                writer.write(String.valueOf(sortElement[i]));
                if(i<sortElement.length-1){
                    writer.write(",");
                }
            }
            System.out.println("execution time is:"+(System.nanoTime()-startTime)/1000000000);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
