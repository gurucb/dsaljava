package org.algo.sort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BubbleSort extends Sort{
    @Override
    public int[] sort(int[] inputElements) {
        int n = inputElements.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i-1;j++){
                if(inputElements[j]>inputElements[j+1]){
                    int temp = inputElements[j];
                    inputElements[j] = inputElements[j+1];
                    inputElements[j+1] = temp;
                }
            }
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
