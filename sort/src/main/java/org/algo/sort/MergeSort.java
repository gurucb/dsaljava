package org.algo.sort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class MergeSort extends Sort {

    @Override
    public int[] sort(int[] inputElements) {
        if(inputElements.length>1){
            int mid = inputElements.length/2;
            int[] left = Arrays.copyOfRange(inputElements,0,mid);
            int[] right = Arrays.copyOfRange(inputElements,mid,inputElements.length);
            sort(left);
            sort(right);

            int arrptr=0;
            int lptr = 0;
            int rptr = 0;

            while(lptr<left.length && rptr<right.length){
                if (left[lptr]<right[rptr]){
                    inputElements[arrptr]=left[lptr];
                    lptr+=1;
                }else {
                    inputElements[arrptr] = right[rptr];
                    rptr+=1;

                }
                arrptr+=1;
            }

            while(lptr<left.length){
                inputElements[arrptr] = left[lptr];
                lptr+=1;
                arrptr+=1;
            }
            while(rptr<right.length){
                inputElements[arrptr] = right[rptr];
                rptr+=1;
                arrptr+=1;

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
