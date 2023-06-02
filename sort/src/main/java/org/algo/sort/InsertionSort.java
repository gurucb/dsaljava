package org.algo.sort;

public class InsertionSort extends Sort{

    @Override
    public int[] sort(int[] inputElements) {
         int n = inputElements.length;
        for (int j = 1; j < n; j++) {
            int key = inputElements[j];
            int i = j-1;
            while((i > -1) && ( inputElements [i] > key)) {
                inputElements [i+1] = inputElements [i];
                i--;
            }
            inputElements[i+1] = key;
        }

        return inputElements;
    }

    @Override
    public void sort(String inputFile, String outputFile) {
 try {
            BufferedReader reader=new BufferedReader(new FileReader(inputFile));
            String line=reader.readLine();
            reader.close();

            String [] element=line.split(" ,");
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
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
