package org.algo.sort;

public class HeapSort extends Sort{
    @Override
    public int[] sort(int[] inputElements) {
        int n= inputElements.length;
        heapSort(inputElements,n);
        return inputElements;
    }

    static void heapify(int a[], int n, int i) {
        int largest = i;
        int left = 2 * i + 1; 
        int right = 2 * i + 2;
        if (left < n && a[left] > a[largest])
            largest = left;
        if (right < n && a[right] > a[largest])
            largest = right; 
        if (largest != i) {
            int temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;
            heapify(a, n, largest);
        }
    }
  
    static void heapSort(int a[], int n){
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(a, n, i);

        for (int i = n - 1; i >= 0; i--) {
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            heapify(a, i, 0);
        }
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
