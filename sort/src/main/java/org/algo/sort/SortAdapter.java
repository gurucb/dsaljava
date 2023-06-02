package org.algo.sort;

public class SortAdapter {
    public static Sort getSortObject(String sortType)
    {
        if(sortType=="merge"){
            MergeSort sort = new MergeSort();
            return sort;
        }
        else if (sortType=="bubble"){
            BubbleSort sort = new BubbleSort();
            return sort;
        }
        else if (sortType=="selection"){
            SelectionSort sort = new SelectionSort() ;
            return sort;
        }
        else if (sortType=="insertion"){
            InsertionSort sort = new InsertionSort();
            return sort;
        }
        else{
            ShellSort sort = new ShellSort();
            return sort;
        }

    }
}
