package org.algo.sort;

public class MergeSort extends Sort {

    @Override
    public int[] sort(int[] inputElements) {
       int start=0;
      int end=inputElements.length-1;
      mergeSort(inputElements,start,end);
        return inputElements;
    }

    void merge(int a[], int beg, int mid, int end){
        int i, j, k;
        int n1 = mid - beg + 1;
        int n2 = end - mid;
        
        int LeftArray[] = new int[n1];
        int RightArray[] = new int[n2];

       
        for (i = 0; i < n1; i++)
            LeftArray[i] = a[beg + i];
        for (j = 0; j < n2; j++)
            RightArray[j] = a[mid + 1 + j];

        i = 0; 
        j = 0; 
        k = beg; 

        while (i < n1 && j < n2) {
            if(LeftArray[i] <= RightArray[j]) {
                a[k] = LeftArray[i];
                i++;
            }
            else {
                a[k] = RightArray[j];
                j++;
            }
            k++;
        }
        while (i<n1) {
            a[k] = LeftArray[i];
            i++;
            k++;
        }

        while (j<n2) {
            a[k] = RightArray[j];
            j++;
            k++;
        }
    }

    void mergeSort(int a[], int beg, int end) {
        if (beg < end) {
            int mid = (beg + end) / 2;
            mergeSort(a, beg, mid);
            mergeSort(a, mid + 1, end);
            merge(a, beg, mid, end);
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
