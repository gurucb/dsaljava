package org.algo.sort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BubbleSort extends Sort{
    @Override
    public int[] sort(int[] inputElements) {

        for (int a = 0; a < inputElements.length; a++){
            for (int b = 0; b < inputElements.length-a-1; b++){
                if (inputElements[b] > inputElements[b+1]){
                    int temp = inputElements[b];
                    inputElements[b] = inputElements[b+1];
                    inputElements[b+1] = temp;

                }
            }
        }

        return new int[0];
    }

    @Override
    public void sort(String inputFile, String outputFile) {

        try {
            FileReader r =new FileReader(inputFile);
            BufferedReader br = new BufferedReader(r);
            String s = null;
            while ((s=br.readLine())!= null){
                String[]  d = s.split(",");

                int [] arr = new int[d.length];
                for (int j = 0; j < d.length; j++){
                    arr[j] = Integer.parseInt(d[j]);
                }
                sort(arr);
                FileWriter Fw = new FileWriter(outputFile);
                for (int i = 0; i < d.length; i++){
                    Fw.write(arr[i]+ ",");
                }
                Fw.close();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
