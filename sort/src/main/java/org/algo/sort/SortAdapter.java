package org.algo.sort;

public class SortAdapter {
    public static Sort getSortObject(String sortType)
    {
        if(sortType.equals("Mergesort")||sortType.equals("mergesort")) {
            return new MergeSort();
        }
        if(sortType.equals("Selectionsort")||sortType.equals("selectionsort")) {
            return new SelectionSort();
        }
        if(sortType.equals("Bubblesort")||sortType.equals("bubblesort")) {
            return new BubbleSort();
        }
        if(sortType.equals("Heapsort")||sortType.equals("heapsort")) {
            return new HeapSort();
        }
        if(sortType.equals("Quicksort")||sortType.equals("quicksort")) {
            return new QuickSort();
        }
        if(sortType.equals("Insertionsort")||sortType.equals("insertionsort")) {
            return new InsertionSort();
        }
        return new MergeSort();
    }
}
