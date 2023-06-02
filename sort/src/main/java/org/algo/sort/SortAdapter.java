package org.algo.sort;

public class SortAdapter {
    public static Sort getSortObject(String sortType)
    {
        if(sortType.equals("BubbleSort")){
           return new BubbleSort();
       }

        if(sortType.equals("BucketSort")){
            return new BucketSort();
        }

        if(sortType.equals("HeapSort")){
            return new HeapSort();
        }

        if(sortType.equals("InsertionSort")){
            return new InsertionSort();
        }

        if(sortType.equals("MergeSort")){
            return new MergeSort();
        }

        if(sortType.equals("QuickSort")){
            return new QuickSort();
        }

        if(sortType.equals("SelectionSort")){
            return new SelectionSort();
        }

        if(sortType.equals("ShellSort")){
            return new ShellSort();
        }


        return new MergeSort();
    
    }
}
