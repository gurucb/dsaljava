package org.algo.sort;

public class SelectionSort extends Sort{
    @Override
    public int[] sort(int[] inputElements) {
        for (int i = 0; i < inputElements.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < inputElements.length; j++){
                if (inputElements[j] < inputElements[index]){
                    index = j;//searching for lowest index
                }
            }
            int smallerNumber = inputElements[index];
            inputElements[index] = inputElements[i];
            inputElements[i] = smallerNumber;
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
