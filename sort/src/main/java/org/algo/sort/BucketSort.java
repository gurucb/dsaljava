package org.algo.sort;

public class BucketSort extends Sort{
    @Override
    public int[] sort(int[] inputElements) {
       int n=inputElements.length;
        List<Integer>[] buckets = new List[n];
        for(int i = 0; i <n; i++) {
            buckets[i] = new LinkedList<>();
        }
        for(int num : inputElements) {
            buckets[hash(num, n)].add(num);
        }
        for(List<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }
        int index = 0;
        for(List<Integer> bucket : buckets) {
            for(int num : bucket){
                inputElements[index++] = num;
            }
        }
        return inputElements;
    }
    
     private static int hash(int num, int n){
        return num/n;
    }

    @Override
    public void sort(String inputFile, String outputFile) {
 try {
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
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
