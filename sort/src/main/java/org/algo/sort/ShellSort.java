package org.algo.sort;

public class ShellSort extends Sort{
    @Override
    public int[] sort(int[] inputElements) {
          int n=inputElements.length;
        for (int interval = n/2; interval > 0; interval /= 2) {
            for (int i = interval; i < n; i += 1) {
                int temp = inputElements[i];
                int j;
                for (j = i; j >= interval &&  inputElements[j - interval] > temp; j -= interval)
                    inputElements[j] =  inputElements[j - interval];
                inputElements[j] = temp;
            }
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
