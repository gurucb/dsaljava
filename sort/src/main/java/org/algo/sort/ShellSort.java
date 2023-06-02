package org.algo.sort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ShellSort extends Sort{
    @Override
    public int[] sort(int[] inputElements) {
        int n = inputElements.length;
        for (int gap = n/2; gap > 0; gap /= 2)
        {
            for (int i = gap; i < n; i += 1)
            {
                int temp = inputElements[i];
                int j;
                for (j = i; j >= gap && inputElements[j - gap] > temp; j -= gap)
                    inputElements[j] = inputElements[j - gap];
                inputElements[j] = temp;
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
